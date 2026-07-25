package api.tests;

import api.client.ReqresClient;
import api.models.UsersListResponse;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class UsersListApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @Test
    public void getUsersListTest() {
        int requestedPage = 2;

        UsersListResponse response =
                reqresClient.getUsers(requestedPage);

        assertEquals(response.getPage(), requestedPage);
        assertFalse(response.getData().isEmpty());

        response.getData().forEach(user -> {
            assertFalse(user.getEmail().isBlank());
            assertFalse(user.getFirstName().isBlank());
            assertFalse(user.getLastName().isBlank());
        });
    }
}