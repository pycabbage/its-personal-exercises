FROM node:22 as base

FROM base as final
ARG API_HOST=api

COPY . /app
WORKDIR /app
RUN corepack prepare pnpm@9.1.2 --activate && \
  corepack pnpm install --frozen-lockfile
RUN corepack pnpm build

CMD ["corepack", "pnpm", "start"]
