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
    void searchNewsVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Проверка отображения блока новостей ", () -> {
            $$(".leading").shouldHave(sizeGreaterThanOrEqual(1));
        });
        step("Проверка заголовка блока новостей ", () -> {
           $(".page-title").shouldHave(Condition.text("Новости"));
        });
    }
    @Test
    @Description("Проверка вкладки Об Институте")
    @DisplayName("Проверка вкладки Об Институте")
    void searchInstituteVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Об институте' ", () -> {
            $(".dropdown-toggle").click();
        });
        step("Проверка адреса Института ", () -> {
            $(".article-intro").shouldHave(Condition.text("Адрес: Приднестровская Молдавская Республика, 3200-MD,  \n" +
                    "г. Тирасполь, ул. Восстания, 2а."));
        });
        step("Проверка истории Института ", () -> {
            $(".article-intro",1).shouldHave(Condition.text("Статус института инженерно-технический факультет получил в 2006 году."));
        });
    }
    @Test
    @Description("Проверка вкладки Наука")
    @DisplayName("Проверка вкладки Наука")
    void searchInstitVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Наука' ", () -> {
            $(".dropdown-toggle",1).click();
        });
        step("Кликаем на ссылку 'Научные конференции и семинары' ", () -> {
            $(".page-header a").click();
        });
        step("Кликаем на 2 страницу ", () -> {
            $("[title='2']").click();
        });
        step("Кликаем на статью О проведении студенческой научной конференции ИТИ по итогам 2016 г. ", () -> {
            $("[href='/nauka/nauchnye-konferentsii-i-seminary/317-o-provedenii-studencheskoj-nauchnoj-konferentsii-iti-po-itogam-2016-g']").click();
        });
        step("Проверка наличия поздравления ", () -> {
            $(".article-content").shouldHave(Condition.text("ПОЗДРАВЛЯЕМ"));
        });
    }
}

