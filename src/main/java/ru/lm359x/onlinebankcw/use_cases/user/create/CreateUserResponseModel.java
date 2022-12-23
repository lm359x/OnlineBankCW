package ru.lm359x.onlinebankcw.use_cases.user.create;

import java.util.UUID;

public class CreateUserResponseModel {
    UUID id;

    public UUID getId() {
        return id;
    }

    public CreateUserResponseModel(UUID id) {
        this.id = id;
    }
}
