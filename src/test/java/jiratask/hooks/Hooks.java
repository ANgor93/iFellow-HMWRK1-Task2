package jiratask.hooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class Hooks {
    @BeforeEach
    void setUp() {
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
    }

    @AfterEach
    void tearDown() {
        clearBrowserCookies();
        close();
    }
}
