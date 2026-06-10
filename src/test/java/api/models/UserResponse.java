package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserResponse {

    private UserData data;

    public UserData getData() {
        return data;
    }
}