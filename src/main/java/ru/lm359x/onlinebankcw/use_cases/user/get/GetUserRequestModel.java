package ru.lm359x.onlinebankcw.use_cases.user.get;

import java.util.UUID;

public class GetUserRequestModel {
    String login;
    String phoneNumber;

    UUID id;

    QueryType type;

    enum QueryType{
        ID, LOGIN, PHONE_NUMBER
    }

    public GetUserRequestModel(String login, String phoneNumber, UUID id, QueryType type) {
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }



}
