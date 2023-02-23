package Tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static ApiSteps.AuthJiraAPI.checkAuthorization;
import static ApiSteps.AuthJiraAPI.getSessionId;
import static ApiSteps.RickAndMortyAPI.*;
import static ApiSteps.UserCreateAPI.*;


public class TestApi {

    @Test
    public void testRaceMatch() {
        getCharacterInfo("2");
        getLastEpisodeNumber();
        getLastCharacterId();
        getLastCharacterInfo();
        raceAssert();
    }

    @Test
    public void testLocMatch() {
        getCharacterInfo("2");
        getLastEpisodeNumber();
        getLastCharacterId();
        getLastCharacterInfo();
        locationAssert();
    }

    @Test
    public void testCreateUser() throws IOException {
        setRequestBody();
        sendPostRequest("/users");
        checkResponseBody();
    }

    @Test
    public void testAuthorization() throws IOException {
        getSessionId();
        checkAuthorization();
    }
}