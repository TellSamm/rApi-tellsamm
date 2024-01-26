package models;


import lombok.AllArgsConstructor;
import lombok.Data;


public class UserUpdateResponse {

    private String name;
    private String job;
    private String updatedAt;

    public UserUpdateResponse(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
