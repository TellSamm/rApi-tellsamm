package models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResponse {

    private String name;
    private String job;
    private String id;
    private String createdAt;

}
