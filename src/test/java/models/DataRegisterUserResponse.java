package models;

import lombok.AllArgsConstructor;
import lombok.Data;


public class DataRegisterUserResponse {
    Integer id;
    String token;

    public DataRegisterUserResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
