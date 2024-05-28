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
public class RequestUpdateUser {
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
