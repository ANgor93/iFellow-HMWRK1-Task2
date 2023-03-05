package jiratask.PageSteps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import io.qameta.allure.Step;
import jiratask.elements.TaskElement;


import static jiratask.elements.TaskElement.activeSprint;
import static jiratask.elements.TaskElement.taskName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskPage {
    @Step("Выбрать задачу")
    @Когда("я выбираю задачу")
    public void choiceTask() {
        activeSprint.click();
        taskName.click();
    }
    @Step("Проверить статус задачи")
    @Тогда("статус задачи равен {string}")
    public void verifyTaskStatus(String expectedStatus) {
        assertEquals(expectedStatus, TaskElement.status.getText());
        System.out.println("Статус задачи В РАБОТЕ");
    }
    @Step("Проверить версию задачи")
    @Тогда("версия задачи равна {string}")
    public void verifyTaskVersion(String expectedVersion) {
        assertEquals(expectedVersion, TaskElement.version.getText());
        System.out.println("Версия задачи Version 2.0");
    }

}
