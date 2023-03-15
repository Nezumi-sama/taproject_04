import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDeliveryTest {

    private WebDriver driver;

    @BeforeAll
    static void configureWebDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void createBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    void orderingCardTest() {
       // Configuration.timeout(10000);

        open("http://localhost:9999/");
        $("[data-test-id='city'] input").sendKeys("Барнаул");
        $("[data-test-id='date'] input").sendKeys("14.03.2023");
        $("[data-test-id='name'] input").sendKeys("Иванов Иван");
        $("[data-test-id='phone'] input").sendKeys("+79101234567");
        $(".checkbox_size_m").click();

     //   $(".notification__title").shouldHave(Condition.text("Успешно!"));

        $(withText("Успешно")).shouldBe(visible);

/*
        driver.findElement(By.cssSelector("[data-test-id=\"city\"] input.input__control")).sendKeys("Барнаул");//---
        driver.findElement(By.cssSelector("[data-test-id=\"date\"] input.input__control")).sendKeys("13.03.2023");//---
        driver.findElement(By.cssSelector("[data-test-id=\"name\"] input.input__control")).sendKeys("Иванов Иван");//---
        driver.findElement(By.cssSelector("[data-test-id=\"phone\"] input.input__control")).sendKeys("+79101234567");//---

        driver.findElement(By.className("checkbox_size_m")).click();
        driver.findElement(By.className("button")).click();

        String actual = driver.findElement(By.cssSelector("[data-test-id='notification']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actual.strip());*/
    }
}
