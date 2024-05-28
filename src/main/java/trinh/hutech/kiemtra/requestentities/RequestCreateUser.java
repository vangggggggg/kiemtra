package trinh.hutech.kiemtra.requestentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trinh.hutech.kiemtra.entities.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateUser {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
