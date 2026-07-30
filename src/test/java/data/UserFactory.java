package data;

import api.models.CreateUserRequest;
import api.models.UpdateUserRequest;

public final class UserFactory {

    private UserFactory() {
    }

    public static CreateUserRequest defaultUser() {
        return CreateUserRequest.builder()
                .name("Evgeniia")
                .job("QA Automation Engineer")
                .build();
    }

    public static UpdateUserRequest updatedUser() {
        return UpdateUserRequest.builder()
                .name("Evgeniia")
                .job("Senior QA Automation Engineer")
                .build();
    }

    public static CreateUserRequest userWithJob(String job) {
        return CreateUserRequest.builder()
                .name("Evgeniia")
                .job(job)
                .build();
    }
}