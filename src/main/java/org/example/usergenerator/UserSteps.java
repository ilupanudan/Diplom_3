package org.example.usergenerator;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.example.usergenerator.User.randomUser;
import static org.example.usergenerator.UserClient.createUserClient;
import static org.example.usergenerator.UserClient.loginClient;

public class UserSteps {

    public static User user;
    public static UserCreds userCreds;
    public static String bearerToken;


    @Step("Создание юзера")
    public static ValidatableResponse createUser() {
        user = randomUser();
        ValidatableResponse response = createUserClient(user);
        bearerToken = response.extract().path("accessToken");

        return response;
    }

    @Step("Удаление юзера")
    public static void deleteUser() {
        if (bearerToken != null){
            userCreds = UserCreds.from(user);
            UserClient.deleteClient();
        }

    }

    @Step("Получаем bearer токен юзера")
    public static String getBearerToken(User user) {
        UserCreds userCreds = UserCreds.from(user);
        bearerToken = loginClient(userCreds).extract().path("accessToken");
        return bearerToken;
    }

}
