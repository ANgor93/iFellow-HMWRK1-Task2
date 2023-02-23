package ApiSteps;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import io.cucumber.java.ru.*;

import static io.restassured.RestAssured.given;


import org.junit.jupiter.api.Assertions;

public class UserCreateAPI {

    public static String requestBody;
    public static String responseName;
    public static String responseJob;

    @Дано("У меня есть запрос на создание пользователя")
    public static void setRequestBody() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/requestBody.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat market");
        requestBody = body.toString();
    }

    @Когда("Я отправляю POST запрос на endpoint {string}")
    public static void sendPostRequest(String endpoint) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri("https://reqres.in/api")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .statusCode(201)
                .extract()
                .response();

        responseName = response.jsonPath().getString("name");
        responseJob = response.jsonPath().getString("job");
    }


    @Тогда("Тело ответа должно содержать имя и работу созданного пользователя")
    public static void checkResponseBody() {
        if ("Tomato".equals(responseName) && "Eat market".equals(responseJob)) {
            System.out.println("Тело ответа содержит имя и работу созданного пользователя Tomato и Eat market");
        } else {
            System.out.println("Тело ответа не содержит имя и работу созданного пользователя Tomato и Eat market");
        }
        Assertions.assertEquals("Tomato", responseName);
        Assertions.assertEquals("Eat market", responseJob);
    }
}