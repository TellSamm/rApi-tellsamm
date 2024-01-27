package models;


public class DataRegisterUserRequest {
    String email;
    String password;

    public DataRegisterUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DataRegisterUserRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
