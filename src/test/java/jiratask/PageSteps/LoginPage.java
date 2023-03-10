package jiratask.PageSteps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

import static jiratask.elements.DashboardElement.profileUser;
import static jiratask.elements.LoginElements.*;

public class LoginPage {

    public static String getUsername() {
        return "agorohov";
    }

    public static String getPassword() {
        return "Qwerty123";
    }


    @Когда("я выполняю логин на сайте с логином {string} и паролем {string}")
    public static void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }


    @Тогда("проверить авторизацию")
    public static void verifyLogin() {
        profileUser.shouldBe(visible, Duration.ofSeconds(10));
        System.out.println("Пользователь успешно авторизован");
    }
}
