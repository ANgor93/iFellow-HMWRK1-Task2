package jiratask.test;


import com.codeborne.selenide.SelenideElement;
import jiratask.PageSteps.*;
import jiratask.elements.DashboardElement;
import jiratask.elements.TaskElement;
import jiratask.hooks.Hooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunTest extends Hooks {

    @Test
        //Авторизоваться в edujira.ifellow.ru
    void shouldBeValidAuthorization() {
        new LoginPage().login();
        assertTrue(new DashboardElement().profileUser.isDisplayed());
    }

    @Test
        //Перейти в проект TestProject
    void shouldBeAbleToOpenTestProject() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        new DashboardPage().dashboardPageProject();
        assertTrue(new DashboardElement().projectTest.isDisplayed());
    }

    @Test
        //Проверить общее количество заведенных задач в проекте ( например в  строке ‘1 из 30’ )
    void shouldShowNumberOfTestTasks() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        new ProjectPage().openTasksList();
        new ProjectPage().numbersOfTaskPageProject();
        assertEquals(ProjectPage.getNumberOfTasks(), 8478);
    }

    @Test
        //Перейти в задачу TestSelenium и проверить статус задачи и привязку в затронутой версии - Version 2.0
    void checkStatusAndVersion() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        TaskPage taskPage = new TaskPage();
        taskPage.choiceTask();
        assertEquals("В РАБОТЕ", taskPage.getStatus());
        assertEquals("Version 2.0", taskPage.getVersion());
    }

    @Test
        //Создать автотестом новый баг с описанием
    void createBugReport() {
        new LoginPage().login();
        new BugReportPage().createBug("Bug title", "Bug description");
        assertTrue(new BugReportPage().isBugReportSuccessful("Bug title"));
    }

    @Test
        //Перевести задачу по статусам до закрытого.
    void changeStatusBugReport() {
        BugReportPage bugReportPage = new BugReportPage();
        new LoginPage().login();
        new BugReportPage().createBug("Bug title", "Bug description");
        bugReportPage.changeBugStatus();

        SelenideElement status = bugReportPage.getStatus();
        assertEquals("ГОТОВО", status.getText());
    }
}
