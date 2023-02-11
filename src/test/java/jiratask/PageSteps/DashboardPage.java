package jiratask.PageSteps;

import com.codeborne.selenide.Condition;

import static jiratask.elements.DashboardElement.*;

public class DashboardPage {

    public void selectProjectTest() {
        projectClick.click();
        projectViewAllLink.click();
        projectName.click();
    }

    public DashboardPage() {
        profileUser.shouldBe(Condition.visible);
    }

    public void dashboardPageProject() {
        projectTest.shouldBe(Condition.visible);
    }
}
