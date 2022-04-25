package ru.spsu.iti.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.spsu.iti.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SpsuTests extends TestBase {
    @Test
    @Description("Проверка новостей")
    @DisplayName("Проверка новостей")
    void searchNewsVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Проверка отображения блока новостей ", () ->
            $$(".leading").shouldHave(sizeGreaterThanOrEqual(1)));
        step("Проверка заголовка блока новостей ", () ->
           $(".page-title").shouldHave(text("Новости")));
    }
    @Test
    @Description("Проверка вкладки Об Институте")
    @DisplayName("Проверка вкладки Об Институте")
    void searchInstituteVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Об институте' ", () ->
                $(".dropdown-toggle").click());
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
        step("Кликаем на ссылку 'Наука' ", () ->
                $(".dropdown-toggle",1).click());
        step("Кликаем на ссылку 'Научные конференции и семинары' ", () ->
                $(".page-header a").click());
        step("Кликаем на 2 страницу ", () ->
                $("[title='2']").click());
        step("Кликаем на статью О проведении студенческой научной конференции ИТИ по итогам 2016 г. ", () ->
                $("[href='/nauka/nauchnye-konferentsii-i-seminary/317-o-provedenii-studencheskoj-nauchnoj-konferentsii-iti-po-itogam-2016-g']").click());
        step("Проверка наличия поздравления ", () -> {
            $(".article-content").shouldHave(text("ПОЗДРАВЛЯЕМ"));
        });
    }
    @Test
    @Description("Проверка вкладки Наука")
    @DisplayName("Проверка вкладки Наука")
    void searchScienceTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Наука' ", () ->
                $(".dropdown-toggle",1).click());
        step("Кликаем на ссылку 'Научная деятельность' ", () ->
                $x("(//a[@href='/nauka/nauchnaya-deyatelnost'])[3]").click());
        step("Проверка наличия блока с контеном ", () -> {
            $(".content-category").shouldHave(text("Научная деятельность"));
        });
    }
    @Test
    @Description("Проверка вкладки Студенту")
    @DisplayName("Проверка вкладки Студенту")
    void searchCongratulationsVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Студенту' ", () ->
                $(".dropdown-toggle",3).click());
        step("Кликаем на ссылку 'Оплата за обучение' ", () ->
                $x("(//a[text()[normalize-space()='Оплата за обучение']])[3]").click());
        step("Проверка наличия стоимости обучения ", () -> {
            $(".page-title").shouldHave(text("оплата за Обучение"));
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchRoleVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () ->
                $(".dropdown-toggle",2).click());
        step("Кликаем на ссылку 'Приемная кампания' ", () ->
                $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click());
        step("Проверка наличия заголовка ", () -> {
            $(".page-title").shouldHave(text("Приемная кампания"));
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchRoleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () ->
                $(".dropdown-toggle",2).click());
        step("Кликаем на ссылку 'Перечень документов для поступления' ", () ->
                $x("(//a[@href='/abiturientu/perechen-dokumentov-dlya-postupleniya'])[3]").click());
        step("Проверка наличия заголовка ", () -> {
            $(".page-title").shouldHave(text("Перечень документов для поступления"));
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchRoleContentVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () ->
                $(".dropdown-toggle",2).click());
        step("Кликаем на ссылку 'Приемная кампания' ", () ->
                $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".article-content").shouldBe(visible);
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchCopywriterVisibleTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () ->
                $(".dropdown-toggle",2).click());
        step("Кликаем на ссылку 'Приемная кампания' ", () ->
                $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $("#t3-footer").shouldBe(visible);
        });
    }
    @Test
    @Description("Проверка вкладки Абитуриенту")
    @DisplayName("Проверка вкладки Абитуриенту")
    void searchCopywriterTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Абитуриенту' ", () ->
                $(".dropdown-toggle",2).click());
        step("Кликаем на ссылку 'Приемная кампания' ", () ->
                $x("(//a[@href='/abiturientu/priemnaya-kampaniya'])[3]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".module").shouldBe(text("Инженерно-технический институт ПГУ им. Т.Г. Шевченко."));
        });
    }
    @Test
    @Description("Проверка вкладки Преподавателю")
    @DisplayName("Проверка вкладки Преподавателю")
    void searchTeacherTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Преподавателю' ", () ->
                $(".dropdown-toggle",4).click());
        step("Кликаем на ссылку 'Образовательные стандарты' ", () ->
                $x("(//a[@href='/prepodavatelyu/informatsiya-dlya-prepodavatelej'])[3]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".t3-footer").shouldBe(text("3300, г. Тирасполь, ул. Восстания, 2а"));
        });
    }
    @Test
    @Description("Проверка вкладки Образование")
    @DisplayName("Проверка вкладки Образование")
    void searchEducationTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Образование' ", () ->
                $(".dropdown-toggle",5).click());
        step("Кликаем на ссылку 'Образовательные стандарты' ", () ->
                $x("(//a[@href='/obrazovanie1/raspisanie-zanyatij-obr'])[3]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".page-title").shouldBe(text("Расписание занятий и звонков"));
        });
    }
    @Test
    @Description("Проверка вкладки Гостевая книга")
    @DisplayName("Проверка вкладки Гостевая книга")
    void searchBookTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Гостевая книга' ", () ->
                $x("//li[@data-id='1368']//a[1]").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".componentheading").shouldBe(text("Гостевая книга"));
        });
    }
    @Test
    @Description("Проверка вкладки Гостевая книга")
    @DisplayName("Проверка вкладки Гостевая книга")
    void searchMessageTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Гостевая книга' ", () ->
                $x("//li[@data-id='1368']//a[1]").click());
        step("Кликаем на кнопку 'Добавить сообщение' ", () ->
                $(".btn").click());
        step("Проверка наличия блока с контентом ", () -> {
            $(".componentheading").shouldBe(text("Гостевая книга - Добавить сообщение"));
        });
    }
    @Test
    @Description("Проверка вкладки Гостевая книга")
    @DisplayName("Проверка вкладки Гостевая книга")
    void searchBackTests() {
        step("Открываем сайт", () -> open(baseUrl));
        step("Кликаем на ссылку 'Гостевая книга' ", () ->
                $x("//li[@data-id='1368']//a[1]").click());
        step("Кликаем на кнопку 'Добавить сообщение' ", () ->
                $(".btn").click());
        step("Кликаем на кнопку 'Вернуться' ", () ->
                $(".btn").click());
        step("Проверка наличия блока с контентом ", () ->
            $(".componentheading").shouldBe(text("Гостевая книга")));
    }
}

