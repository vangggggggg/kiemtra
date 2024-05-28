package trinh.hutech.kiemtra.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "username", length = 50, unique = true,nullable = false)
    private String username;
    @Column(name = "password", length = 250, nullable = false)
    private String password;
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstname;
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;
    @Column(name = "email", length = 50, unique = true , nullable = false)
    private String email;
    @Column(name = "deleted")
    private boolean isdeleted;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;
}
