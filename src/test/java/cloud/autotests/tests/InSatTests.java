package cloud.autotests.tests;

import cloud.autotests.config.Project;
import cloud.autotests.helpers.AllureAttachments;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class InSatTests extends TestBase {
    @Test
    @Description("Тест регистрации сайта компании ИнСАТ")
    @DisplayName("Тест регистрации")
    @Tag("registrationTest")
    void registrationTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Нажать \"Личный кабинет\"", () -> $(".kabinet").click());

        step("Нажать \"Регистрация\"", () -> $(byLinkText("Регистрация")).click());

        step("Нажать \"ЧАСТНОЕ ЛИЦО\"", () -> $(".ui-button-text").click());

        step("Ввести данные для регистрации", () -> {
            step("Ввести имя", () -> $("[name='REGISTER[NAME]']").setValue(user.getFirstName()));
            step("Ввести фамилию", () -> $("[name='REGISTER[LAST_NAME]']").setValue(user.getLastName()));
            step("Ввести отчество", () -> $("[name='REGISTER[SECOND_NAME]']").setValue(user.getSecondName()));
            step("Ввести e-mail", () -> $("[name='REGISTER[EMAIL]']").setValue(user.getEmail()));
            step("Ввести номер телефона", () -> $("[name='REGISTER[PERSONAL_PHONE]']").setValue(user.getPhone()));
            step("Ввести логин", () -> $("[name='REGISTER[LOGIN]']").setValue(user.getLogin()));
            step("Ввести пароль", () -> $("[name='REGISTER[PASSWORD]']").setValue(user.getPassword()));
            step("Ввести подтверждение пароля", () -> $("[name='REGISTER[CONFIRM_PASSWORD]']").setValue(user.getPassword()));
        });

        step("Выбрать опции", () -> {
            step("Подтвердить доступ к демо-версиям", () -> $(withText("Хочу получить доступ к демо-версиям программных продуктов:")).click());
//            step("Подтвердить доступ к новостным рассылкам", () -> {
//                $(withText("Подписаться на новости Инсат")).click();
//            });
            step("Согласие на обработку персональных данных", () -> $("[name='agreement']").sibling(0).click());
        });

        step("Нажать \"Зарегистрироваться\"", () -> $("#register").click());

        step("Проверить сообщение о посланном e-mail", () ->
                $("#cboxLoadedContent").
                    shouldHave(text("На указанный в форме e-mail придет запрос на подтверждение регистрации.")));

        step("Закрыть сообщение о посланном e-mail", () -> {
            $("#cboxClose").click();
            $("#cboxLoadedContent").shouldNotBe(visible);
        });

    }

    @Test
    @Description("Тесты авторизации сайта компании ИнСАТ")
    @DisplayName("Тест успешной авторизации")
    @Tag("authorisationTest")
    void authorisationSuccessfulTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Нажать \"Личный кабинет\"", () -> $(".kabinet").click());

        step("Ввести данные для авторизации", () -> {
            step("Ввести логин", () -> $("[name='USER_LOGIN']").setValue(user.getLogin()));
            step("Ввести фамилию", () -> $("[name='USER_PASSWORD']").setValue(user.getPassword()));
        });

        step("Нажать \"Войти\"", () -> $("[name='Login']").click());

        step("Проверка успешной авторизации", () -> {
            step("Проверить вход в личный кабинет", () -> $(".work-box")
                    .shouldHave(text("Личный кабинет")));
            step("Проверить ФИО", () -> $(".cabinet-col-2")
                    .shouldHave(text(String.format(" %s %s", user.getFirstName(), user.getLastName()))));
        });
    }

    @Test
    @Description("Тесты авторизации сайта компании ИнСАТ")
    @DisplayName("Тест неуспешной авторизации")
    @Tag("authorisationTest")
    void authorisationFailedTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Нажать \"Личный кабинет\"", () -> $(".kabinet").click());

        step("Ввести данные для авторизации", () -> {
            step("Ввести логин", () -> $("[name='USER_LOGIN']").setValue(user.getLogin().substring(1)));
            step("Ввести фамилию", () -> $("[name='USER_PASSWORD']").setValue(user.getPassword().substring(1)));
        });

        step("Нажать \"Войти\"", () -> $("[name='Login']").click());

        step("Проверка неуспешной авторизации", () -> $(".work-box").shouldHave(text("Неверный логин или пароль.")));
    }


    @Test
    @Description("Тесты поиска на сайте компании ИнСАТ")
    @DisplayName("Тест успешного поиска")
    @Tag("searchTest")
    void searchTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Ввести в строку поиска текст", () -> $("[placeholder='Поиск']").setValue(Project.config.searchText()));

        step("Проверить работу автодополнения", () -> $(".ui-autocomplete").shouldHave(text(Project.config.searchText()), Duration.ofSeconds(5)));

        AllureAttachments.addScreenshotAs("Autocompletion screenshot");

        step("Нажать \"Найти\"", () -> $(".search-form").$("[type='submit']").click());

        step("Проверить результаты поиска", () -> $(".item-content").shouldHave(text(Project.config.searchText()), Duration.ofSeconds(5)));

    }

    @Test
    @Description("Тесты поиска на сайте компании ИнСАТ")
    @DisplayName("Тест безуспешного поиска")
    @Tag("searchFailedTest")
    void searchFailedTest() {

        step("Открыть https://insat.ru/", () -> open("/"));

        step("Ввести в строку поиска текст", () -> $("[placeholder='Поиск']").setValue(Project.config.searchText()));

        step("Нажать \"Найти\"", () -> $(".search-form").$("[type='submit']").click());

        step("Проверить сообщение об отсутствии результатов поиска", () -> $(".item-content").shouldHave(text("К сожалению, на ваш поисковый запрос ничего не найдено."), Duration.ofSeconds(5)));

    }

}