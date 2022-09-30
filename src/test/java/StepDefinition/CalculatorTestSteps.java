package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class CalculatorTestSteps extends Calculator {
    private Calculator calculator;
    double x;
    double y;
    double total;

    @Given("^Даны два числа (\\d) и (\\d)$")
    public void twoNumbers(double x, double y) {
        this.x = x;
        this.y = y;
        this.calculator = new Calculator();
    throw new io.cucumber.java.PendingException();
    }

    @Then("^Вычисляем сумму двух чисел$")
    public void  sumOfTwoNumbers() {
        total = calculator.sum(x, y);
    throw new io.cucumber.java.PendingException();
    }

    @When("^Результат должен быть равен (\\d)$")
    public void resultIsEqualTo(double res) {
        Assert.assertEquals(res, total, 0.0001);
    throw new io.cucumber.java.PendingException();
    }
}
