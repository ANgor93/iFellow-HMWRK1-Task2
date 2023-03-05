package jiratask.PageSteps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static jiratask.elements.DashboardElement.profileUser;
import static jiratask.elements.LoginElements.*;

public class LoginPage {

    public static String getUsername() {
        return "agorohov";
    }

    public static String getPassword() {
        return "Qwerty123";
    }

    @Step("Выполнить логин на сайте")
    @Дано("я выполняю логин на сайте")
    public static void login() {
        usernameField.setValue(getUsername());
        passwordField.setValue(getPassword());
        loginButton.click();
    }

    @Step("Проверить авторизацию")
    @Тогда("проверить авторизацию")
    public static void verifyLogin() {
        profileUser.shouldBe(visible, Duration.ofSeconds(10));
        System.out.println("Пользователь успешно авторизован");
    }
}
