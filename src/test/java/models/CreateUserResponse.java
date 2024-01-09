package models;

public class CreateUserResponse {

    private String name;
    private String job;
    private String id;
    private String createAt;

    public CreateUserResponse(String name, String job, String id, String createAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createAt = createAt;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
