package ru.spsu.iti.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.spsu.iti.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;

public class SpsuTests extends TestBase {
    @Test
    @Description("Проверка новостей")
    @DisplayName("Проверка новостей")
    void searchVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Проверка отображения блока новостей ", () -> {
            $$(".leading").shouldHave(sizeGreaterThanOrEqual(1));
        });
        step("Проверка заголовка блока новостей ", () -> {
           $(".page-title").shouldHave(Condition.text("Новости"));
        });
    }
}
