package PageObject.JiraTest;

import Hooks.WebHooks;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static utils.Configuration.getConfigurationValue;
import static PageObject.PageFunctions.NewBugCaseFunctions.*;
import static PageObject.PageFunctions.LoginPageFunction.*;
import static PageObject.PageFunctions.TestProjectPageFunctions.*;

public class JiraTest extends WebHooks {

    @Test
    @Tag("Test1")
    @DisplayName("1. Авторизоваться в edujira.ifellow.ru")
    public void Test_1() {
        authorization(getConfigurationValue("login"));
    }

    @Test
    @Tag("Test2")
    @DisplayName("2. Открыть страницу проекта TestProject и список задач")
    public void Test_2() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
    }

    @Test
    @Tag("Test3")
    @DisplayName("3. Открыть список задач в проекте TestProject и вывести общее количество заведенных задач")
    public void Test_3() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
    }

    @Test
    @Tag("Test4")
    @DisplayName("4. Открыть задачу TestSelenium_bug, проверить статус и привязку к версии - Version 2.0")
    public void Test_4() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
    }
    @Test
    @Tag("Test5")
    @DisplayName("5. Создать новый тест-кейс с описанием")
    public void Test_5() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
        NewBugCaseMethod(getConfigurationValue("topic"));
    }

    @Test
    @Tag("Test6")
    @DisplayName("6. Поиск вновь заведённого тест-кейса и его закрытие")
    public void Test_6() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
        NewBugCaseMethod(getConfigurationValue("topic"));
        searchNewTestCase(getConfigurationValue("topic"));
    }
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();
}
