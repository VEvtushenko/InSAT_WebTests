# Проект по автоматизации тестрования сайта компании ИнСАТ

## Навигация

<a href="#Реализованные-проверки">Реализованные проверки</a>

<a href="#Запуск-тестов-из-терминала">Запуск тестов из терминала</a>

<a href="#Параметры-тестов">Параметры тестов</a>

<a href="#Сборка-в-Jenkins">Сборка в Jenkins</a>

<a href="#Отчет-Allure-Report">Отчет Allure Report</a>

<a href="#Уведомления-в-Telegram">Уведомления в Telegram</a>

<a href="#Видеозапись-прохождения-теста">Видеозапись прохождения теста</a>

<a href="#Применявшийся-стек">Применявшийся стек</a>

## Реализованные проверки

* <a href="#Проверка работы формы регистрации">Проверка заполнения и отправки формы регистрации нового пользователя</a>
* * <img  title="Скриншот формы регистрации" src="readme-files/screenshots/registration_form.png"  alt="Скриншот формы регистрации">
* <a href="#Проверки авторизации">Проверка авторизации</a>
* * Тест успешной авторизации
* * <img  title="Скриншот успешной авторизации" src="readme-files/screenshots/authorisation.png"  alt="Скриншот успешной авторизации">
* * Тест неуспешной авторизации
* * <img  title="Скриншот неуспешной авторизации" src="readme-files/screenshots/unsuccessful_authorisation.png"  alt="Скриншот неуспешной авторизации">
* <a href="#Проверка поиска">Проверка работы автодополнения строки поиска и поиска по сайту</a>
* * Тест автодополнения поиска
* * <img  title="Скриншот работы автодополнения" src="readme-files/screenshots/autocompletion.png"  alt="Скриншот работы автодополнения">
* * Тест успешного поиска
* * <img  title="Скриншот результатов успешного поиска" src="readme-files/screenshots/successful_search.png"  alt="Скриншот результатов успешного поиска">
* * Тест безуспешного поиска
* * <img  title="Скриншот результатов безуспешного поиска" src="readme-files/screenshots/unsuccessful_search.png"  alt="Скриншот результатов безуспешного поиска">

<a href="#Навигация">Назад к оглавлению</a>

## Параметры тестов
Для изменения настроек запуска тестов отредактируйте файл
``
remote.properties
``
в папке
``
src/test/resources/config
``
Для настройки среды выполнения

* browser (Браузер, по умолчанию chrome)
* browserVersion (Версия браузера, по умолчанию 106.0)
* browserSize (Размер окна браузера, по умолчанию 1920x1080)
* remoteDriverUrl (URL и логин/пароль хоста, на котором вы запускаете тесты)
* videoStorage (URL с которого вы получаете видеозапись теста)

Для настройки тестовых данных:

* userPassword (Пароль пользователя сайта, если оставить поле пустым будет сгенерирован случайным образом)
* userName (Логин пользователя сайта, если оставить поле пустым будет сгенерирован случайным образом)
* firstName (Имя пользователя сайта, если оставить поле пустым будет сгенерировано случайным образом)
* secondName (Отчество пользователя сайта, необязательное поле)
* lastName (Фамилия пользователя сайта, если оставить поле пустым будет сгенерирована случайным образом)
* testEmail (Электронная почта пользователя сайта, если оставить поле пустым будет сгенерирована случайным образом)
* testPhone (Телефон пользователя сайта, если оставить поле пустым будет сгенерирован случайным образом)
* searchText (Текст для проверки поиска, значение по умолчанию "Обучение")

Также для изменения параметров тестов вы можете запустить их из консоли с соответствующими ключами, по аналогии с примерами ниже

```bash
.gradlew clean testSiteSections -Dbrowser="{Название браузера}" -DbrowserVersion="{Версия браузера}" -DbrowserSize="{}" -DremoteDriverUrl="{https://Имя пользователя:Пароль@Адрес хоста, на котором проводится запуск тестов}"
```
Например такая команда запустит тесты в браузере Опера, версии 87.0
```bash
.gradlew clean testSiteSections -Dbrowser="opera" -DbrowserVersion="87.0"
```


## Запуск тестов из терминала
#### Запуск всех тестов
```bash
gradle clean tests
```
#### Запуск теста регистрации
```bash
gradle clean registrationTest
```
#### Запуск тестов авторизации
```bash
gradle clean authorisationTest
```
#### Запуск теста успешного поиска
```bash
gradle clean searchTest
```
#### Запуск теста безуспешного поиска
```bash
gradle clean searchFailedTest
```
<a href="#Навигация">Назад к оглавлению</a>

## Отчет-Allure-Report:
Для получения отчёта с помощью команды в консоли введите
```bash
allure serve build/allure-results
```

<a target="_blank" href="https://jenkins.autotests.cloud/job/">Здесь вы можете увидеть отчёт Allure report последней сборки в Jenkins</a>

<a href="#Навигация">Назад к оглавлению</a>

## Сборка в Jenkins
<a target="_blank" href="https://jenkins.autotests.cloud/job/">Здесь вы можете попробовать запустить тесты самостоятельно</a>

<a href="#Навигация">Назад к оглавлению</a>

##Уведомления в Telegram
Вы можете получать уведомления о статусе тестов в Telegram.
Для получения уведомления <a target="_blank" href="https://t.me/">вступите в эту группу</a>

Уведомления будут приходить после каждого запуска <a target="_blank" href="https://jenkins.autotests.cloud/job/">этой сборки в Jenkins </a>

Чтобы узнать больше о настройке уведомлений, <a target="_blank" href="https://github.com/qa-guru/allure-notifications">пожалуйста, посетите страницу разработчика</a>

<a href="#Навигация">Назад к оглавлению</a>

## Видеозапись прохождения теста
<p><img src="readme-files/test_video/" alt="Здесь должна быть gif с тестом"></p>

<a href="#Навигация">Назад к оглавлению</a>

## Применявшийся стек
<p align="center">
<img width="4%" title="IntelliJ IDEA" src="readme-files/logo/Intelij_IDEA.svg"  alt="IntelliJ IDEA">
<img width="4%" title="Java" src="readme-files/logo/Java.svg" alt="Java">
<img width="4%" title="Selenide" src="readme-files/logo/Selenide.svg" alt="Selenide">
<img width="4%" title="Selenoid" src="readme-files/logo/Selenoid.svg" alt="Selenoid">
<img width="4%" title="Allure Report" src="readme-files/logo/Allure_Report.svg" alt="Allure Report">
<img width="4%" title="Gradle" src="readme-files/logo/Gradle.svg" alt="Gradle">
<img width="4%" title="JUnit5" src="readme-files/logo/JUnit5.svg" alt="JUnit5">
<img width="4%" title="GitHub" src="readme-files/logo/GitHub.svg" alt="GitHub">
<img width="4%" title="Jenkins" src="readme-files/logo/Jenkins.svg" alt="Jenkins">
<img width="4%" title="Telegram" src="readme-files/logo/Telegram.svg" alt="Telegram">
</p>

<a href="#Навигация">Назад к оглавлению</a>

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
