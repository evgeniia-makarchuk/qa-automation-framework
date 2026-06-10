package api.tests;

import api.client.ReqresClient;
import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import base.BaseUiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void createUserTest() {

        CreateUserRequest request =
                new CreateUserRequest(
                        "Evgeniia",
                        "QA Automation Engineer"
                );

        CreateUserResponse response =
                reqresClient.createUser(request);

        assertEquals(response.getName(), "Evgeniia");
        assertEquals(response.getJob(), "QA Automation Engineer");

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}