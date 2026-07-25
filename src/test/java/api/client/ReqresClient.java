package api.client;

import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import api.models.UserResponse;
import io.restassured.response.Response;

public class ReqresClient extends BaseApiClient {

    public Response getUserByIdResponse(int userId) {
        return requestSpec()
                .when()
                .get("/api/users/" + userId);
    }

    public UserResponse getUserById(int userId) {
        return getUserByIdResponse(userId)
                .then()
                .log().all()
                .statusCode(200)
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