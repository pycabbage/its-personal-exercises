package api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AuthUser {
    @Id
    private Long id;
    private String username;
    private String password;
}
