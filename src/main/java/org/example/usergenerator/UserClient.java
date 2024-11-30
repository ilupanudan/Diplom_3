package org.example.usergenerator;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static utils.UserConstants.*;

public class UserClient {

    public static ValidatableResponse createUserClient(User user){
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then();

    }
    public static void deleteClient() {
        given()
                .baseUri(BASE_URL)
                .header("authorization", UserSteps.bearerToken)
                .when()
                .delete(USER_PATH)
                .then();
    }
}
