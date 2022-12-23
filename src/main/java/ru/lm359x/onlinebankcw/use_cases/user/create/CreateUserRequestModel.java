package ru.lm359x.onlinebankcw.use_cases.user.create;

public class CreateUserRequestModel {
    String firstName;
    String lastName;
    String login;
    String password;
    String phoneNumber;

    public CreateUserRequestModel(String firstName, String lastName, String login, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
