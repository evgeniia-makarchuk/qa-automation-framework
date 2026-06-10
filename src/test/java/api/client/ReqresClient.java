package api.client;

import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import api.models.UserResponse;

public class ReqresClient extends BaseApiClient {

    public UserResponse getUserById(int userId) {
        return requestSpec()
                .when()
                .get("/api/users/" + userId)
                .then()
                .log().all()
                .extract()
                .as(UserResponse.class);
    }

    public CreateUserResponse createUser(CreateUserRequest request) {
        return requestSpec()
                .body(request)
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .extract()
                .as(CreateUserResponse.class);
    }
}