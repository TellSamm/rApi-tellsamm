package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
