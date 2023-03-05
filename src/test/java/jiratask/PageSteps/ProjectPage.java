package jiratask.PageSteps;

import com.codeborne.selenide.Condition;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;

import static jiratask.elements.ProjectElement.*;


public class ProjectPage {
    @Step("Открыть список задач")
    @Когда("я открываю список задач")
    public void openTasksList() {
        taskMenu.click();
        switchFilter.click();
        butnAllTask.click();
    }


    @Step("Выбрать общее количество задач")
    @Когда("я выбираю общее количество задач")
    public void selectTotalNumberOfTasks() {
        numberOfTasks.shouldBe(Condition.visible);
    }

    @Step("Проверить количество задач")
    @Тогда("количество задач равно {int}")
    public void verifyNumberOfTasksCucumber(int expectedNumberOfTasks) {
        int actualNumberOfTasks = Integer.parseInt(numberOfTasks.getText().split(" ")[2]);
        Assertions.assertEquals(expectedNumberOfTasks, actualNumberOfTasks, "Количество задач не соответствует ожидаемому значению");
        System.out.println("Количество задач равно " + expectedNumberOfTasks);
    }
}
