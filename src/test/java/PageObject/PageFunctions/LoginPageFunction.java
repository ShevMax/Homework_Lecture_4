package PageObject.PageFunctions;

import PageObject.PageElement.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Configuration.getConfigurationValue;


public class LoginPageFunction extends LoginPage {

    @When("^в поле Логин ввести: (.*)$")
    public void loginMethod(String login) {
        loginField.shouldBe(visible).sendKeys(login);
    }

    @And("^в поле Пароль ввести: (.*)$")
    public void passwordMethod(String password) {
        passwordField.sendKeys(password);
    }

    @And("^далее нажать кнопку Войти$")
    public void pressInputButton () {
        inputButton.shouldBe(enabled).click();
    }

    @Then("^из Профиля пользователя извлекается текущее имя пользователя")
    public String getCurrentUsername() {
        return currentUsername.shouldHave(attribute("data-username")).attr("data-username");
    }

    @And("^сравниватеся с ранее введённым значением login, что является проверкой успешности авторизации$")
    public void checkAuthorizationSuccessful() {
        assertTrue(currentUsername.is(visible));
        assertEquals(getConfigurationValue("login"), getCurrentUsername());
    }
}