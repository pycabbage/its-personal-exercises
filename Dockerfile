# syntax=docker/dockerfile:1

FROM eclipse-temurin:21-jdk-jammy as base

FROM base as build

COPY . /src
WORKDIR /src

SHELL ["/bin/bash", "-o", "pipefail", "-c"]
RUN \
    --mount=type=cache,target=build \
    --mount=type=cache,target=bin \
    --mount=type=cache,target=.gradle \
    --mount=type=cache,target=${HOME}/.gradle \
    ./gradlew build -x test && \
    cp $(ls -S build/libs/*.war | head -n1) /tmp/app.war

################################################################################

FROM eclipse-temurin:21-jre-jammy AS final

# Create a non-privileged user that the app will run under.
# See https://docs.docker.com/go/dockerfile-user-best-practices/
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

# Copy the executable from the "package" stage.
COPY --from=build --chown=appuser \
    /tmp/app.war app.war

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.war" ]
