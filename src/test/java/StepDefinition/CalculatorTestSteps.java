package StepDefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CalculatorTestSteps {
    private Calculator calculator;
    double x;
    double y;
    double total;

    @Given("^Даны два числа (\\d) и (\\d)$")
    public void twoNumbers(double x, double y) {
        this.x = x;
        this.y = y;
        this.calculator = new Calculator();
    }

    @Then("^Вычисляем сумму двух чисел$")
    public void  sumOfTwoNumbers() {
        total = calculator.sum(x, y);
    }

    @When("^Результат должен быть равен (\\d)$")
    public void resultIsEqualTo(double result) {
        Assert.assertEquals(result, total, 0);
    }
}
