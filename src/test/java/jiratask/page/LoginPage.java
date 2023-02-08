package jiratask.page;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement usernameField = $(By.xpath("//input[@name='os_username']"));
    private SelenideElement passwordField = $(By.xpath("//input[@name='os_password']"));
    private SelenideElement loginButton = $(By.xpath("//input[@id='login']"));

    public static String getUsername() {
        return "agorohov";
    }

    public static String getPassword() {
        return "Qwerty123";
    }

    public LoginPage login() {
        usernameField.setValue(getUsername());
        passwordField.setValue(getPassword());
        loginButton.click();
        return this;
    }

}