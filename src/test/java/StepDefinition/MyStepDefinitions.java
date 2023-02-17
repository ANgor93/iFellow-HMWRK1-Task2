package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;



public class MyStepDefinitions {

    private int number1;
    private int number2;
    private int result;

    @Дано("я ввожу числа {int} и {int}")
    public void enterNumbers(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Когда("я складываю их вместе")
    public void iCalculateTheirSum() {
        result = number1 + number2;
    }

    @Тогда("я получаю сумму {int}")
    public void theResultShouldBe(int expectedSum) {
        Assert.assertEquals(expectedSum, result);
        System.out.println("Выполнено: сумма " + number1 + " и " + number2 + " равна " + result);
    }

}
