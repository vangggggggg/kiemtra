package trinh.hutech.kiemtra.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id", nullable = false)
    private String role_id;
    @Column(name = "role_name", nullable = false)
    private String role_name;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
}
