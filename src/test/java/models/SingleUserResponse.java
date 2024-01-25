package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleUserResponse {

    private UserResponse data;
    private Support support;

}
