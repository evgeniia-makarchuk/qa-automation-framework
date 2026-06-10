package api.client;

import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    private static final String BASE_URL = "https://reqres.in";

    protected RequestSpecification requestSpec() {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("x-api-key", getApiKey())
                .log().all();
    }

    private String getApiKey() {
        String apiKey = System.getenv("REQRES_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("REQRES_API_KEY environment variable is not set");
        }

        return apiKey;
    }
}