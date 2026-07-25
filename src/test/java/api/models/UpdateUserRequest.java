package api.models;

public class UpdateUserRequest {

    private final String name;
    private final String job;

    private UpdateUserRequest(Builder builder) {
        this.name = builder.name;
        this.job = builder.job;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static class Builder {

        private String name;
        private String job;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public UpdateUserRequest build() {
            return new UpdateUserRequest(this);
        }
    }
}