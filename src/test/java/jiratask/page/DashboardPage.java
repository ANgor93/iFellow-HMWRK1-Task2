package jiratask.page;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    public SelenideElement profileUser = $(By.xpath("//a[@data-username='agorohov']"));
    public SelenideElement projectClick = $(By.xpath("//a[@id='browse_link']"));
    public SelenideElement projectViewAllLink = $(By.xpath("//li[@id='project_view_all_link']"));
    public SelenideElement projectName = $(By.xpath("//td[@class='cell-type-name']//child::a[@original-title='Test']"));
    public SelenideElement projectTest = $(By.xpath("//span[@id='issues-subnavigation-title']"));


    public void selectProjectTest() {
        projectClick.click();
        projectViewAllLink.click();
        projectName.click();

    }

    public DashboardPage() {
        profileUser.shouldBe(Condition.visible);

    }

    public void dashboardPageProject() {
        projectTest.shouldBe(Condition.visible);
    }
}
