package jiratask.PageSteps;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;

import static jiratask.elements.DashboardElement.*;


public class DashboardPage {

    @Когда("я выбираю проект")
    public void selectProjectTest() {
        projectClick.click();
        projectViewAllLink.click();
        projectName.click();
    }

    public DashboardPage() {
        profileUser.shouldBe(Condition.visible);
    }

    @Тогда("я нахожусь на странице дашборда проекта")
    public void dashboardPageProject() {
        projectTest.shouldBe(Condition.visible);
    }
}
