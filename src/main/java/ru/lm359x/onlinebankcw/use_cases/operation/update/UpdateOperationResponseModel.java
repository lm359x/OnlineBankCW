package ru.lm359x.onlinebankcw.use_cases.operation.update;

import java.util.UUID;

public class UpdateOperationResponseModel {
    UUID id;

    public UpdateOperationResponseModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
