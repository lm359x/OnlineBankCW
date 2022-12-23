package ru.lm359x.onlinebankcw.use_cases.user.update;

import java.util.UUID;

public class UpdateUserRequestModel {
    UUID id;
    String firstName;
    String lastName;
    String login;
    String password;
    String phoneNumber;

    public UpdateUserRequestModel(UUID id, String firstName, String lastName, String login, String password, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
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
