package jiratask.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BugReportPage {

    public static final By SUCCESS_MESSAGE = By.xpath("//a[@class='issue-created-key issue-link']");
    private static final By BUG_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Bug title')]");
    private static final By STATUS_LOCATOR = By.xpath("//span[contains(@class, 'jira-issue-status') and text()='Готово']");

    public void changeBugStatus() {
        $(BUG_LINK_LOCATOR).click();
        $(By.xpath("//span[contains(text(), 'Бизнес-процесс')]")).click();
        $(By.xpath("//span[@class='trigger-label' and contains(text(), 'Выполнено')]")).click();
    }

    public SelenideElement getStatus() {
        return $(STATUS_LOCATOR);
    }

    public static void createBug(String bugTitle, String bugDescription) {
        SelenideElement createBugButton = $(By.xpath("//a[@id='create_link']"));
        SelenideElement choiceBug = $(By.xpath("//div[@id='issuetype-single-select']//child::input"));
        SelenideElement bugTitleField = $(By.xpath("//input[@id='summary']"));
        SelenideElement bugDescriptionField = $(By.xpath("//textarea[@id='description']"));
        SelenideElement submitBugButton = $(By.xpath("//input[@accesskey='S' and @value='Создать'] "));


        createBugButton.click();
        choiceBug.setValue("Ошибка");
        bugTitleField.sendKeys(bugTitle);
        bugDescriptionField.sendKeys(bugDescription);
        submitBugButton.click();


    }

    public boolean isBugReportSuccessful(String title) {
        return $(SUCCESS_MESSAGE).waitUntil(Condition.text(title), 10000).exists();
    }

}
