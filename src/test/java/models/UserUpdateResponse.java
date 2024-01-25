package models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateResponse {

    private String name;
    private String job;
    private String updatedAt;
}
