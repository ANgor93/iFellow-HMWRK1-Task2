package jiratask.elements;


import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    public static SelenideElement usernameField = $(By.xpath("//input[@name='os_username']"));
    public static SelenideElement passwordField = $(By.xpath("//input[@name='os_password']"));
    public  static SelenideElement loginButton = $(By.xpath("//input[@id='login']"));
}
