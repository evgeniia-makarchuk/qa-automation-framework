package api.tests;

import api.client.ReqresClient;
import api.models.UpdateUserRequest;
import api.models.UpdateUserResponse;
import org.testng.annotations.Test;

import static data.UserFactory.updatedUser;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UpdateUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void updateUserTest() {
        UpdateUserRequest request = updatedUser();

        UpdateUserResponse response =
                reqresClient.updateUser(2, request);

        assertEquals(response.getName(), request.getName());
        assertEquals(response.getJob(), request.getJob());
        assertNotNull(response.getUpdatedAt());
    }
}