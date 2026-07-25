package api.tests;

import api.client.ReqresClient;
import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void createUserTest() {

        CreateUserRequest request = CreateUserRequest.builder()
                .name("Evgeniia")
                .job("QA Automation Engineer")
                .build();

        CreateUserResponse response =
                reqresClient.createUser(request);

        assertEquals(response.getName(), request.getName());
        assertEquals(response.getJob(), request.getJob());

        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}