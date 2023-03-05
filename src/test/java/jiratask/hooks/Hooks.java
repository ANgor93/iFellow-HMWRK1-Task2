package jiratask.hooks;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;


import static com.codeborne.selenide.Selenide.*;


public class Hooks {
    @Before
    public void option() {
        open("https://edujira.ifellow.ru");
        setupAllureReports();
    }


    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            AllureHelper.takeScreenshot(scenario.getName());
        }
        closeWebDriver();
    }


}
