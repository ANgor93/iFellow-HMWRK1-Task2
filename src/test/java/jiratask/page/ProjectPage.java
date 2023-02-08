package jiratask.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    public SelenideElement taskMenu = $(By.xpath("//span[contains(@class,'aui-iconfont-issues')]"));
    public SelenideElement switchFilter = $(By.xpath("//button[@id='subnav-trigger' and text()='Переключить фильтр']"));
    public SelenideElement butnAllTask = $(By.xpath("//a[@class='aui-dropdown2-radio' and text()='Все задачи']"));
    public SelenideElement numberOfTasks = $(By.xpath("//div[@class='showing']//child::span[contains(text(), '1 из')]"));

    public void openTasksList() {
        taskMenu.click();
        switchFilter.click();
        butnAllTask.click();
    }

    public void numbersOfTaskPageProject() {
        numberOfTasks.shouldBe(Condition.visible);
    }

}
