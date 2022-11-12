package cloud.autotests.data;

import cloud.autotests.config.Project;
import com.github.javafaker.Faker;

public class User {

    private final String firstName;
    private final String lastName;
    private final String secondName;
    private final String email;
    private final String phone;
    private final String login;
    private final String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User() {

        Faker faker = new Faker();

        if (!Project.config.firstName().equals("")) {
            firstName = Project.config.firstName();
        } else {
            firstName = faker.name().firstName();
        }

        if (!Project.config.lastName().equals("")) {
            lastName = Project.config.lastName();
        } else {
            lastName = faker.name().lastName();
        }

        secondName = Project.config.secondName();

        if (!Project.config.testEmail().equals("")) {
            email = Project.config.testEmail();
        } else {
            email = faker.internet().emailAddress();
        }

        if (!Project.config.testPhone().equals("")) {
            phone = Project.config.testEmail();
        } else {
            phone = faker.phoneNumber().phoneNumber();
        }

        if (!Project.config.userName().equals("")) {
            login = Project.config.userName();
        } else {
            login = faker.name().username();
        }

        if (!Project.config.userPassword().equals("")) {
            password = Project.config.userPassword();
        } else {
            password = faker.crypto().md5();
        }
    }

}
