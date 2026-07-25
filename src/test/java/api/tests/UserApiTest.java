package api.tests;

import api.client.ReqresClient;
import api.models.UserResponse;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class UserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void getUserByIdTest() {
        UserResponse user = reqresClient.getUserById(2);

        assertEquals(user.getData().getId(), 2);
        assertEquals(
                user.getData().getEmail(),
                "janet.weaver@reqres.in"
        );
    }

    @Test
    public void getNonExistingUserTest() {
        reqresClient
                .getUserByIdResponse(23)
                .then()
                .log().all()
                .statusCode(404)
                .body("$", anEmptyMap());
    }
}