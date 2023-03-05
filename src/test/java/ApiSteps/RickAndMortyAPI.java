package ApiSteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RickAndMortyAPI {
    public static String characterId;
    public static String mortyLocation;
    public static String mortySpecies;
    public static String lastCharRace;
    public static String lastCharLoc;
    public static int lastEpisode;
    public static int lastCharacter;

    private static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("https://rickandmortyapi.com/api")
            .build();

    @Дано("информация о персонаже с ID {string}")
    @Step("Извлечение информации о персонаже с ID {0}")
    public static void getCharacterInfo(String id) {
        Response gettingCharacter = given()
                .spec(REQUEST_SPECIFICATION)
                .filter(new AllureRestAssured())
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();

        characterId = new JSONObject(gettingCharacter.getBody().asString()).get("id").toString();
        mortyLocation = new JSONObject(gettingCharacter.getBody().asString()).getJSONObject("location").get("name").toString();
        mortySpecies = new JSONObject(gettingCharacter.getBody().asString()).get("species").toString();
    }

    @Затем("получить номер последнего эпизода, в котором появился персонаж")
    @Step("Извлечение номера последнего эпизода")
    public static void getLastEpisodeNumber() {
        Response getLastEpisode = given()
                .spec(REQUEST_SPECIFICATION)
                .filter(new AllureRestAssured())
                .when()
                .get("/character/" + characterId)
                .then()
                .extract()
                .response();

        int episode = (new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        lastEpisode = Integer.parseInt(new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
    }

    @Затем("получить идентификатор последнего персонажа из последнего эпизода")
    @Step("Извлечение идентификатора последнего персонажа")
    public static void getLastCharacterId() {
        Response gettingLastChar = given()
                .spec(REQUEST_SPECIFICATION)
                .filter(new AllureRestAssured())
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract()
                .response();

        int lastCharIndex = (new JSONObject(gettingLastChar.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharacter = Integer.parseInt(new JSONObject(gettingLastChar.getBody().asString()).getJSONArray("characters").get(lastCharIndex).toString().replaceAll("[^0-9]", ""));
    }

    @Затем("получить информацию о последнем персонаже")
    @Step("Получить информацию о последнем персонаже")
    public static void getLastCharacterInfo() {
        Response lastCharInfo = given()
                .spec(REQUEST_SPECIFICATION)
                .filter(new AllureRestAssured())
                .when()
                .get("/character/" + lastCharacter)
                .then()
                .extract()
                .response();

        lastCharRace = new JSONObject(lastCharInfo.getBody().asString()).get("species").toString();
        lastCharLoc = new JSONObject(lastCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
    }

    @Тогда("проверить совпадение местонахождения")
    @Step("Проверить совпадение местонахождения")
    public static void locationAssert() {
        if (mortyLocation.equals(lastCharLoc)) {
            System.out.println("Местонахождение последнего персонажа и Морти совпадает");
        } else {
            System.out.println("Местонахождение последнего персонажа и Морти не совпадает");
        }
        Assertions.assertEquals(mortyLocation, lastCharLoc);
    }

    @Тогда("проверить совпадение расы")
    @Step("Проверить совпадение расы")
    public static void raceAssert() {
        if (mortySpecies.equals(lastCharRace)) {
            System.out.println("Раса последнего персонажа и Морти совпадает");
        } else {
            System.out.println("Раса последнего персонажа и Морти не совпадает");
        }
        Assertions.assertEquals(mortySpecies, lastCharRace);
    }

}
