package api.tests;

import api.client.ReqresClient;
import api.models.UpdateUserRequest;
import api.models.UpdateUserResponse;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UpdateUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void updateUserTest() {
        UpdateUserRequest request = UpdateUserRequest.builder()
                .name("Evgeniia")
                .job("Senior QA Automation Engineer")
                .build();

        UpdateUserResponse updatedUser =
                reqresClient.updateUser(2, request);

        assertEquals(updatedUser.getName(), request.getName());
        assertEquals(updatedUser.getJob(), request.getJob());
        assertNotNull(updatedUser.getUpdatedAt());
    }
}