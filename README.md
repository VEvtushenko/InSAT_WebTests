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
* <a href="#Проверки авторизации">Проверка авторизации</a>
* * Тест успешной авторизации
* * <img  title="Скриншот успешной авторизации" src="readme-files/screenshots/"  alt="Services">
* * Тест неуспешной авторизации
* * <img  title="Скриншот неуспешной авторизации" src="readme-files/screenshots/"  alt="Services">
* <a href="#Проверка поиска">Проверка работы автодополнения строки поиска и поиска по сайту</a>
* * Проверка работы автодополнения
* * <img  title="Скриншот работы автодополнения" src="readme-files/screenshots/"  alt="Services">
* * Тест неуспешной авторизации
* * <img  title="Скриншот Скриншот результатов поиска" src="readme-files/screenshots/services.png"  alt="Services">
    
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
* browser (Браузер, по умолчанию chrome)
* browserVersion (Версия браузера, по умолчанию 106.0)
* browserSize (Размер окна браузера, по умолчанию 1920x1080)
* remoteDriverUrl (URL и логин/пароль хоста, на котором вы запускаете тесты)
* videoStorage (URL с которого вы получаете видеозапись теста)
* userPassword Пароль пользователя сайта
* userName Логин пользователя сайта
* firstName Имя пользователя сайта
* lastName Фамилия пользователя сайта
* secondName Отчество пользователя сайта
* testEmail = Электронная почта пользователя сайта
* testPhone = Телефон пользователя сайта

Если вы оставите эти поля пустыми их значения будут сгенерированны автоматически, случайным образом


Или запустите тесты из консоли с соответствующими ключами

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
#### Запуск тестов поиска
```bash
gradle clean searchTest
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
