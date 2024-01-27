package models;

import com.google.gson.annotations.SerializedName;

public class UnsuccessRegistrationResponse {

    @SerializedName("error")
    private String error;

    public UnsuccessRegistrationResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
