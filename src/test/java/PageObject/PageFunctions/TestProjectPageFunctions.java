package PageObject.PageFunctions;

import PageObject.PageElement.TestProjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static utils.Configuration.getConfigurationValue;


public class TestProjectPageFunctions extends TestProjectPage {

    @When("^в меню Проекты выбрать \"TestProject\", а в подменю \"Задачи\" изменить фильтр на \"Все задачи\"$")
    public void clickProjectButton() {
        menuProjectsButton.shouldBe(visible,Duration.ofSeconds(25)).click();
        selectElementTestProject.shouldBe(visible,Duration.ofSeconds(25)).click();
        taskList.shouldBe(visible,Duration.ofSeconds(20)).click();
    }

    @Then("получаем общее количество заведенных задач в проекте \"TestProject\"$")
    public void clickTaskList() {
        switchFilter.shouldBe(visible,Duration.ofSeconds(20)).click();
        allTasks.shouldBe(visible,Duration.ofSeconds(30)).click();
        String totalNumberOfTasks = valueAllTasks.shouldBe(visible,Duration.ofSeconds(25)).getText();
        System.out.println("Общее количество заведённых задач = " + totalNumberOfTasks);
    }

    @When("^в строке Поиск ввести название тест-кейса \"TestSelenium_bug\"$")
    public void searchTaskMethod() {
        searchString.shouldBe(visible).sendKeys(getConfigurationValue("task"));
        searchString.pressEnter();
    }

    @Then("^можно проверить, что статус тест-кейса: \"СДЕЛАТЬ\"$")
    public void checkStatusTestCase() {
        String statusTask = checkStatus.shouldBe(visible, Duration.ofSeconds(25)).getText();
        Assertions.assertEquals(statusTask, "СДЕЛАТЬ", "Ошибка");
        System.out.println("Статус тест-кейса TEST-21967 = " + statusTask);
    }

    @And("^номер затронутой версии: \"Version 2.0\"$")
    public void checkVersionTestCase() {
        String versionTask = checkVersion.shouldBe(visible,Duration.ofSeconds(25)).getText();
        System.out.println("Номер версии тест-кейса = " + versionTask);
        Assertions.assertEquals(versionTask, "Version 2.0", "Ошибка");
    }
}

