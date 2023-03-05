package jiratask.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class BugReportElement {
    public static SelenideElement succesMessage = $(By.xpath("//a[@class='issue-created-key issue-link']"));
    public static SelenideElement bugLinkLocator = $(By.xpath("//a[contains(text(), 'bug title')]"));
    public static SelenideElement statusLocator = $(By.xpath("//span[contains(@class, 'jira-issue-status') and text()='Готово']"));
    public static SelenideElement createBugButton = $(By.xpath("//a[@id='create_link']"));
    public static SelenideElement choiceBug = $(By.xpath("//div[@id='issuetype-single-select']//child::input"));
    public static SelenideElement bugTitleField = $(By.xpath("//input[@id='summary']"));
    public static SelenideElement bugDescriptionField = $(By.xpath("//textarea[@id='description']"));
    public static SelenideElement submitBugButton = $(By.xpath("//input[@accesskey='S' and @value='Создать']"));
    public static SelenideElement  businessProcess = $(By.xpath("//span[contains(text(), 'Бизнес-процесс')]"));
    public static SelenideElement statusTrigger = $(By.xpath("//span[@class='trigger-label' and contains(text(), 'Выполнено')]"));
}
