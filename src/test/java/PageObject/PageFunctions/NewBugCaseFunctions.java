package PageObject.PageFunctions;

import PageObject.PageElement.NewBugCase;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

import static PageObject.PageElement.TestProjectPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static utils.Configuration.getConfigurationValue;

public class NewBugCaseFunctions extends NewBugCase {
    @When("^в верхем трее меню баг-трекера Jira нажать кнопку \"Создать\"$")
    public static void NewBugCaseMethod() {
        newCaseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTaskPage.shouldBe(visible, Duration.ofSeconds(60));
    }
     @Then("^в открывшемся окне \"Создание задачи\" заполнить необходимые поля$")
     public void fillBugCasePage() {
         clickFieldTypeTask.shouldBe(visible, Duration.ofSeconds(30)).click();
         clickFieldTypeTask.sendKeys("Ошибка");
         clickFieldTypeTask.pressEnter();
         fieldTopic.shouldBe(visible).sendKeys(getConfigurationValue("topic"));
         descriptionTask.click();
         switchTo().frame(descriptionTask);
         descriptionFieldTask.setValue("Тут должен быть какой-то комментарий");
         switchTo().defaultContent();
         affectedVersionsField.click();
         switchTo().frame(affectedVersionsField);
         descriptionFieldTask.setValue("Сетевое окружение");
         switchTo().defaultContent();
         fixVersion.scrollIntoView(true).click();
         choosingVersion.scrollIntoView(true).click();
         changePerformerButton.click();
     }

     @And("^далее нажать кнопку \"Создать\"$")
     public static void pressCreateButton() {
          clickCreateButton.click();
        //clickCancelButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @When("^В поле \"Поиск\" вводим название \"Test-case for solving a bug\" вновь заведенного тест-кеса$")
    public static void searchNewTestCase() {
        taskList.shouldBe(visible, Duration.ofSeconds(20)).click();
        switchFilter.shouldBe(visible, Duration.ofSeconds(20)).click();
        myOpenTask.shouldBe(visible, Duration.ofSeconds(25)).click();
        openMyTestCase.shouldBe(visible, Duration.ofSeconds(25)).click();
    }

     @And("^В открывшемся окне заполняем все необходимы поля$")
     public void fillNewBugCasePage() {
         changeStatusButton.shouldBe(visible, Duration.ofSeconds(25)).click();
         Selenide.sleep(1000);
         String statusTestCase = statusValue.getText();
         Assertions.assertEquals(statusTestCase, "В РАБОТЕ", "Ошибка");
     }

      @Then("^Переводим тест-кейс \"Test-case for solving a bug\" в статус \"Выполнено\"$")
      public static void changeStatusNewBugCase() {
        businessProcessButton.shouldBe(visible, Duration.ofSeconds(35)).click();
        executedProcessButton2.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(1000);
        String statusTestCaseAgain=statusValue.getText();
        Assertions.assertEquals(statusTestCaseAgain, "ГОТОВО", "Ошибка");
    }
}