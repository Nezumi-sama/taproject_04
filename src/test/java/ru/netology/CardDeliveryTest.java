package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {

    @BeforeEach
    void createUrl() {
        open("http://localhost:9999/");

    }

    @Test
    void orderingCardTest() {
        $("[data-test-id='city'] input.input__control").sendKeys("Барнаул");
        $("[data-test-id='date'] input.input__control").sendKeys("19.03.2023");
        $("[data-test-id='name'] input.input__control").sendKeys("Иванов Иван");
        $("[data-test-id='phone'] input.input__control").sendKeys("+79101234567");
        $(".checkbox_size_m").click();

       // $("button").click();
        $$("button").find(Condition.exactText("Забронировать")).click();

        $(withText("Успешно!")).shouldBe(visible, Duration.ofMillis(30000));


    }
}
