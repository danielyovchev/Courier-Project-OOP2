package project.courier.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String type;
}
