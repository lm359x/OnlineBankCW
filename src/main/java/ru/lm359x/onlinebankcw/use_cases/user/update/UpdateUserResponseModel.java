package ru.lm359x.onlinebankcw.use_cases.user.update;

import java.util.UUID;

public class UpdateUserResponseModel {
    UUID uuid;

    public UpdateUserResponseModel(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
