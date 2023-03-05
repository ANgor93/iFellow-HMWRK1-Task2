package jiratask.PageSteps;


import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.Assert.assertTrue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jiratask.elements.BugReportElement;

import static com.codeborne.selenide.Selenide.$;
import static jiratask.elements.BugReportElement.succesMessage;

public class BugReportPage {
    @Step("Изменить статус бага")
    @Когда("я изменяю статус бага")
    public void changeBugStatus() {
        $(BugReportElement.bugLinkLocator).click();
        $(BugReportElement.businessProcess).click();
        $(BugReportElement.statusTrigger).click();
    }

    @Step("Создать баг с заголовком {bugTitle} и описанием {bugDescription}")
    @Когда("я создаю баг с заголовком {string} и описанием {string}")
    public void createBug(String bugTitle, String bugDescription) {
        SelenideElement createBugButton = $(BugReportElement.createBugButton);
        SelenideElement choiceBug = $(BugReportElement.choiceBug);
        SelenideElement bugTitleField = $(BugReportElement.bugTitleField);
        SelenideElement bugDescriptionField = $(BugReportElement.bugDescriptionField);
        SelenideElement submitBugButton = $(BugReportElement.submitBugButton);

        createBugButton.click();
        choiceBug.setValue("Ошибка");
        bugTitleField.sendKeys(bugTitle);
        bugDescriptionField.sendKeys(bugDescription);
        submitBugButton.click();
    }

    @Step("Проверить успешное создание бага с заголовком {title}")
    @Тогда("баг успешно создан с заголовком {string}")
    public void isBugReportSuccessful(String title) {
        assertTrue($(succesMessage).waitUntil(Condition.text(title), 10000).exists());
        System.out.println("Баг успешно создан");
    }


    @Step("Статус бага равен {expectedStatus}")
    @Тогда("статус бага равен {string}")
    public void getStatus(String expectedStatus) {
        SelenideElement status = $(BugReportElement.statusLocator);
        status.shouldBe(Condition.text(expectedStatus));
    }
}
