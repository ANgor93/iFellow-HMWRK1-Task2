package ApiSteps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Files;

import java.io.IOException;

import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AuthJiraAPI {
    static {
        RestAssured.filters(new AllureRestAssured());
    }

    public static String sessionId;

    @Step("Авторизуюсь в Jira")
    @Когда("я авторизуюсь в Jira")
    public static void getSessionId() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/auth.json"))));

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body.toString())
                .when()
                .post("https://edujira.ifellow.ru/rest/auth/1/session");

        sessionId = response.getCookie("JSESSIONID");
    }


    @Step("Проверяю, что авторизация прошла успешно")
    @Тогда("авторизация прошла успешно")
    public static void checkAuthorization() {
        if (sessionId != null) {
            System.out.println("Авторизация прошла успешно");
        } else {
            System.out.println("Ошибка авторизации");
        }
        Assertions.assertNotNull(sessionId);
    }
}
