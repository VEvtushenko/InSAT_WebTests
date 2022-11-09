package cloud.autotests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class InSatTests extends TestBase {
    @Test
    @Description("Тест регистрации сайта компании ИнСАТ")
    @DisplayName("Тест регистрации")
    void registrationTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Нажать \"Личный кабинет\"", () -> $(".kabinet").click());

        step("Нажать \"Регистрация\"", () -> $(byLinkText("Регистрация")).click());

        step("Нажать \"ЧАСТНОЕ ЛИЦО\"", () -> $(".ui-button-text").click());

        step("Ввести данные для регистрации", () -> {
            step("Ввести имя", () -> $("[name='REGISTER[NAME]']").setValue(firstName));
            step("Ввести фамилию", () -> $("[name='REGISTER[LAST_NAME]']").setValue(lastName));
            step("Ввести отчество", () -> $("[name='REGISTER[SECOND_NAME]']").setValue(secondName));
            step("Ввести e-mail", () -> $("[name='REGISTER[EMAIL]']").setValue(testEmail));
            step("Ввести номер телефона", () -> $("[name='REGISTER[PERSONAL_PHONE]']").setValue(testPhone));
            step("Ввести логин", () -> $("[name='REGISTER[LOGIN]']").setValue(testLogin));
            step("Ввести пароль", () -> $("[name='REGISTER[PASSWORD]']").setValue(testPassword));
            step("Ввести подтверждение пароля", () -> $("[name='REGISTER[CONFIRM_PASSWORD]']").setValue(testPassword));
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
    @DisplayName("Тест авторизации")
    void authorisationTest() {
        step("Открыть https://insat.ru/", () -> open("/"));

        step("Нажать \"Личный кабинет\"", () -> $(".kabinet").click());

        step("Ввести данные для авторизации", () -> {
            step("Ввести логин", () -> $("[name='USER_LOGIN']").setValue(testLogin));
            step("Ввести фамилию", () -> $("[name='USER_PASSWORD']").setValue(testPassword));
        });

        step("Нажать \"Войти\"", () -> $("[name='Login']").click());

        step("Проверка успешной авторизации", () -> {
            step("Проверить вход в личный кабинет", () -> $(".work-box")
                    .shouldHave(text("Личный кабинет")));
            step("Проверить ФИО", () -> $(".cabinet-col-2")
                    .shouldHave(text(String.format(" %s %s", firstName, lastName))));
        });
    }

}