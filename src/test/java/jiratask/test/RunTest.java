package jiratask.test;


import com.codeborne.selenide.SelenideElement;
import jiratask.hooks.Hooks;
import jiratask.page.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunTest extends Hooks {

    @Test
        //Авторизоваться в edujira.ifellow.ru
    void shouldBeValidAuthorization() {
        new LoginPage().login();
        assertTrue(new DashboardPage().profileUser.isDisplayed());
    }

    @Test
        //Перейти в проект TestProject
    void shouldBeAbleToOpenTestProject() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        new DashboardPage().dashboardPageProject();
        assertTrue(new DashboardPage().projectTest.isDisplayed());
    }

    @Test
        //Проверить общее количество заведенных задач в проекте ( например в  строке ‘1 из 30’ )
    void shouldShowNumberOfTestTasks() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        new ProjectPage().openTasksList();
        new ProjectPage().numbersOfTaskPageProject();
        assertTrue(new ProjectPage().numberOfTasks.isDisplayed());
    }

    @Test
        //Перейти в задачу TestSelenium и проверить статус задачи и привязку в затронутой версии - Version 2.0
    void checkStatusAndVersion() {
        new LoginPage().login();
        new DashboardPage().selectProjectTest();
        TaskPage taskPage = new TaskPage();
        taskPage.choiceTask();
        assertEquals("В РАБОТЕ", taskPage.status.getText());
        assertEquals("Version 2.0", taskPage.version.getText());
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
