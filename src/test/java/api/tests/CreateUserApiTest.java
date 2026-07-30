package api.tests;

import api.client.ReqresClient;
import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static data.UserFactory.defaultUser;
import static data.UserFactory.userWithJob;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CreateUserApiTest {

    private final ReqresClient reqresClient = new ReqresClient();

    @DataProvider(name = "jobs")
    public Object[][] jobs() {
        return new Object[][]{
                {"QA Automation Engineer"},
                {"Team Lead"},
                {"Software Developer"}
        };
    }

    @Test
    public void createUserWithCustomJobTest() {
        CreateUserRequest request = userWithJob("Team Lead");

        CreateUserResponse response =
                reqresClient.createUser(request);

        assertEquals(response.getName(), request.getName());
        assertEquals(response.getJob(), request.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }

    @Test(dataProvider = "jobs")
    public void createUserWithDifferentJobsTest(String job) {
        CreateUserRequest request = userWithJob(job);

        CreateUserResponse response =
                reqresClient.createUser(request);

        assertEquals(response.getName(), request.getName());
        assertEquals(response.getJob(), request.getJob());
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}