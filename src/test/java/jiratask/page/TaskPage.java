package jiratask.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class TaskPage {
    private SelenideElement taskName = $(xpath("//div[contains(@class, '10100')]//child::span[contains(text(), 'TestSelenium')]"));
    public SelenideElement status = $(xpath("//span[text()='В работе']//parent::span[@id='status-val']"));
    public SelenideElement version = $(xpath("//span[@class='shorten' and @id='fixVersions-field']"));

    public SelenideElement activeSprint = $(By.xpath("//span[contains(@class,'aui-iconfont-board')]"));

    public void choiceTask() {
        activeSprint.click();
        taskName.click();
    }

}