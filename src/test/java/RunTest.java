import WebHooks.Hooks;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunTest extends Hooks {

    // Тест открытия сайта Google
    @Test
    public void testGoogleSite() {
        open("https://www.google.com/");
        System.out.println("Тестирование сайта Google");
    }

    // Тест функции поиска на сайте Google
    @Test
    public void testSearchFunctionality() {
        open("https://www.google.com/");
        $("input[name='q']").setValue("кошки").pressEnter();
        $("input[class='gLFyf'][value='кошки']").shouldBe(Condition.appear);
    }

    // Тест логотипа Google
    @Test
    public void testGoogleLogo() {
        open("https://goo.su/NzJxyva");
        $("#logo").shouldBe(Condition.visible);
        $("#logo").click();
        assertTrue(url().matches("https://www.google.com/.*"));
    }

    // Тест автодополнения предложений на сайте Google
    @Test
    public void testAutoCompleteSuggestions() {
        open("https://www.google.com/");
        $("input[name='q']").setValue("t");
        SelenideElement suggestion = $("div.UUbT9");
        suggestion.shouldBe(Condition.appear);
        suggestion.shouldHave(Condition.text("translate"));
    }

    // Тест поиска изображений на сайте Google
    @Test
    public void testGoogleImagesSearch() {
        open("https://www.google.com/");
        $("a[data-pid='2']").click();
        $("input[name='q']").setValue("nature").pressEnter();
        SelenideElement firstImage = $$("img").first();
        firstImage.shouldBe(Condition.appear);

        $("input[name='q']").setValue("mountains").pressEnter();
        firstImage = $$("img").first();
        firstImage.shouldBe(Condition.appear);
    }

    // Тест поиска мест на сайте Google Maps
    @Test
    public void testGoogleMapsSearch() {
        open("https://www.google.com/maps");

        $("input[name='q']").setValue("Красная площадь, Москва").pressEnter();
        SelenideElement map = $(By.xpath("//*[@id='scene']/div[3]/canvas"));
        map.shouldBe(Condition.appear);

        $("input[name='q']").setValue("Eiffel Tower, Paris").pressEnter();
        map = $(By.xpath("//*[@id='scene']/div[3]/canvas"));
        map.shouldBe(Condition.appear);
    }

    // Тест Google переводчика
    @Test
    public void testGoogleTranslate() {
        open("https://translate.google.com/");

        // Выбор языков для перевода
        $(By.xpath("//button[@jsname='zumM6d']")).click();
        $(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]" +
                "/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[2]/input")).setValue("немецкий").pressEnter();
        // Ввод фразы для перевода
        $(By.xpath("//textarea[@class='er8xn']")).setValue("hello world");

        // Ожидание появления перевода
        SelenideElement target = $(By.xpath("//div[@class='lRu31']"));

        // Проверка перевода
        String translatedPhrase = target.getText();
        assertEquals("Hallo Welt", translatedPhrase);
    }

    // тест который должен упасть, как просили
    @Test
    public void testGoogleTranslateFall() {
        open("https://translate.google.com/");

        $(By.xpath("//button[@jsname='zumM6d']")).click();
        $(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]" +
                "/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[2]/input")).setValue("испанский").pressEnter();

        $(By.xpath("//textarea[@class='er8xn']")).setValue("привет мир");

        SelenideElement target = $(By.xpath("//div[@class='lRu31']"));

        String translatedPhrase = target.getText();
        assertEquals("Hello world", translatedPhrase);
    }

    // Тест гугл калькулятора
    @Test
    public void testGoogleCalculator() {
        open("https://www.google.com/");
        $("input[name='q']").setValue("100*3").pressEnter();

        // Проверка отображения результата
        SelenideElement result = $(By.xpath("//*[@id='cwos']"));
        result.shouldBe(Condition.appear);
        result.shouldHave(Condition.text("300"));
    }
    
}