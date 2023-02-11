package jiratask.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class TaskElement {
    public static SelenideElement taskName = $(By.xpath("//div[contains(@class, '10100')]//child::span[contains(text(), 'TestSelenium')]"));
    public static SelenideElement status = $(By.xpath("//span[text()='В работе']//parent::span[@id='status-val']"));
    public static SelenideElement version = $(By.xpath("//span[@class='shorten' and @id='fixVersions-field']"));
    public static SelenideElement activeSprint = $(By.xpath("//span[contains(@class,'aui-iconfont-board')]"));
}