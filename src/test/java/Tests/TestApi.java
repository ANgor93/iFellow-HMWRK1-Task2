package Tests;

import hooks.Hooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static ApiSteps.AuthJiraAPI.checkAuthorization;
import static ApiSteps.AuthJiraAPI.getSessionId;
import static ApiSteps.RickAndMortyAPI.*;
import static ApiSteps.UserCreateAPI.*;


public class TestApi extends Hooks {

    @Test
    @DisplayName("Проверка совпадения расы")
    public void testRaceMatch() {
        getCharacterInfo("2");
        getLastEpisodeNumber();
        getLastCharacterId();
        getLastCharacterInfo();
        raceAssert();
    }

    @Test
    @DisplayName("Проверка совпадения локации")
    public void testLocMatch() {
        getCharacterInfo("2");
        getLastEpisodeNumber();
        getLastCharacterId();
        getLastCharacterInfo();
        locationAssert();
    }

    @Test
    @DisplayName("Создания пользователя")
    public void testCreateUser() throws IOException {
        setRequestBody();
        sendPostRequest("/users");
        checkResponseBody();
    }

    @Test
    @DisplayName("Авторизация в jira")
    public void testAuthorization() throws IOException {
        getSessionId();
        checkAuthorization();
    }
}