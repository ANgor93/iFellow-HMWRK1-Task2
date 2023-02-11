package jiratask.PageSteps;


import static jiratask.elements.LoginElements.*;

public class LoginPage {

    public static String getUsername() {
        return "agorohov";
    }

    public static String getPassword() {
        return "Qwerty123";
    }

    public void login() {

        usernameField.setValue(getUsername());
        passwordField.setValue(getPassword());
        loginButton.click();
    }
}
