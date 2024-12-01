package org.example.usergenerator;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.example.usergenerator.UserSteps.bearerToken;
import static utils.UserConstants.*;

public class UserClient {

    public static ValidatableResponse createUserClient(User user) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then().log().all();

    }

    public static void deleteClient() {
        given()
                .baseUri(BASE_URL)
                .header("authorization", bearerToken)
                .when()
                .delete(USER_PATH)
                .then().log().all();
    }

    public static ValidatableResponse loginClient(UserCreds userCreds) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(userCreds)
                .when()
                .post(LOGIN_PATH)
                .then().log().all();

    }
}
