package api.tests;

import api.client.ReqresClient;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyOrNullString;

public class DeleteUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void deleteUserTest() {
        reqresClient
                .deleteUser(2)
                .then()
                .log().all()
                .statusCode(204)
                .body(emptyOrNullString());
    }
}