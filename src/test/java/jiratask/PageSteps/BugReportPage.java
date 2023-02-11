package jiratask.PageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import jiratask.elements.BugReportElement;

import static com.codeborne.selenide.Selenide.$;

import static jiratask.elements.BugReportElement.succesMessage;

public class BugReportPage {

    public void changeBugStatus() {
        $(BugReportElement.bugLinkLocator).click();
        $(BugReportElement.businessProcess).click();
        $(BugReportElement.statusTrigger).click();
    }

    public SelenideElement getStatus() {
        return $(BugReportElement.statusLocator);
    }

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

    public boolean isBugReportSuccessful(String title) {
        return $(succesMessage).waitUntil(Condition.text(title), 10000).exists();
    }
}