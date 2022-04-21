package ru.spsu.iti.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.spsu.iti.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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
           $(".page-title").shouldHave(text("Новости"));
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
            $(".article-intro").shouldHave(text("Адрес: Приднестровская Молдавская Республика, 3200-MD,  \n" +
                    "г. Тирасполь, ул. Восстания, 2а."));
        });
        step("Проверка истории Института ", () -> {
            $(".article-intro",1).shouldHave(text("Статус института инженерно-технический факультет получил в 2006 году."));
        });
    }
    @Test
    @Description("Проверка вкладки Наука")
    @DisplayName("Проверка вкладки Наука")
    void searchScienceVisibleTests() {
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
            $(".article-content").shouldHave(text("ПОЗДРАВЛЯЕМ"));
        });
    }
    @Test
    @Description("Проверка вкладки Студенту")
    @DisplayName("Проверка вкладки Студенту")
    void searchCongratulationsVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Студенту' ", () -> {
            $(".dropdown-toggle",3).click();
        });
        step("Кликаем на ссылку 'Оплата за обучение' ", () -> {
           $x("(//a[text()[normalize-space()='Оплата за обучение']])[3]").click();
        });
        step("Проверка наличия стоимости обучения ", () -> {
            $(".page-title").shouldHave(text("оплата за обучение"));
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchEnrolleeVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () -> {
            $(".dropdown-toggle",2).click();
        });
        step("Кликаем на ссылку 'Приемная кампания' ", () -> {
            $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click();
        });
        step("Проверка наличия заголовка ", () -> {
            $(".page-title").shouldHave(text("Приемная кампания"));
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchEnrolleeСontentVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () -> {
            $(".dropdown-toggle",2).click();
        });
        step("Кликаем на ссылку 'Приемная кампания' ", () -> {
            $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click();
        });
        step("Проверка наличия блока с контентом ", () -> {
            $(".article-content").shouldBe(visible);
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchCopywriterVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () -> {
            $(".dropdown-toggle",2).click();
        });
        step("Кликаем на ссылку 'Приемная кампания' ", () -> {
            $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click();
        });
        step("Проверка наличия блока с контентом ", () -> {
            $("#t3-footer").shouldBe(visible);
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchCopywriterTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () -> {
            $(".dropdown-toggle",2).click();
        });
        step("Кликаем на ссылку 'Приемная кампания' ", () -> {
            $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click();
        });
        step("Проверка наличия блока с контентом ", () -> {
            $(".module").shouldBe(text("Инженерно-технический институт ПГУ им. Т.Г. Шевченко."));
        });
    }
}

