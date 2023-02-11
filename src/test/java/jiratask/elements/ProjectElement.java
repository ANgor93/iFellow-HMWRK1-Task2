package jiratask.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectElement {
    public static SelenideElement taskMenu = $(By.xpath("//span[contains(@class,'aui-iconfont-issues')]"));
    public static SelenideElement   switchFilter = $(By.xpath("//button[@id='subnav-trigger' and text()='Переключить фильтр']"));
    public static SelenideElement   butnAllTask = $(By.xpath("//a[@class='aui-dropdown2-radio' and text()='Все задачи']"));
    public static SelenideElement   numberOfTasks = $(By.xpath("//*[@class='showing']//span"));
}
