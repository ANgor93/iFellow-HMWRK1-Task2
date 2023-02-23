package ApiSteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
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

    @Дано("я запрашиваю информацию о персонаже с ID {string}")
    public static void getCharacterInfo(String id) {
        Response gettingCharacter = given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();

        characterId = new JSONObject(gettingCharacter.getBody().asString()).get("id").toString();
        mortyLocation = new JSONObject(gettingCharacter.getBody().asString()).getJSONObject("location").get("name").toString();
        mortySpecies = new JSONObject(gettingCharacter.getBody().asString()).get("species").toString();
    }

    @Затем("я получаю номер последнего эпизода, в котором появился персонаж")
    public static void getLastEpisodeNumber() {
        Response getLastEpisode = given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("/character/" + characterId)
                .then()
                .extract()
                .response();

        int episode = (new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").length() - 1);
        lastEpisode = Integer.parseInt(new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]", ""));
    }

    @Затем("я получаю идентификатор последнего персонажа из последнего эпизода")
    public static void getLastCharacterId() {
        Response gettingLastChar = given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("/episode/" + lastEpisode)
                .then()
                .extract()
                .response();

        int lastCharIndex = (new JSONObject(gettingLastChar.getBody().asString()).getJSONArray("characters").length() - 1);
        lastCharacter = Integer.parseInt(new JSONObject(gettingLastChar.getBody().asString()).getJSONArray("characters").get(lastCharIndex).toString().replaceAll("[^0-9]", ""));
    }

    @Затем("я получаю информацию о последнем персонаже")
    public static void getLastCharacterInfo() {
        Response lastCharInfo = given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("/character/" + lastCharacter)
                .then()
                .extract()
                .response();

        lastCharRace = new JSONObject(lastCharInfo.getBody().asString()).get("species").toString();
        lastCharLoc = new JSONObject(lastCharInfo.getBody().asString()).getJSONObject("location").get("name").toString();
    }

    @Тогда("местонахождение персонажа должно совпадать с местонахождением Морти")
    public static void locationAssert() {
        if (mortyLocation.equals(lastCharLoc)) {
            System.out.println("Местонахождение последнего персонажа и Морти совпадает");
        } else {
            System.out.println("Местонахождение последнего персонажа и Морти не совпадает");
        }
        Assertions.assertEquals(mortyLocation, lastCharLoc);
    }

    @Тогда("раса персонажа должна совпадать с расой Морти")
    public static void raceAssert() {
        if (mortySpecies.equals(lastCharRace)) {
            System.out.println("Раса последнего персонажа и Морти совпадает");
        } else {
            System.out.println("Раса последнего персонажа и Морти не совпадает");
        }
        Assertions.assertEquals(mortySpecies, lastCharRace);
    }

}
