package ru.lm359x.onlinebankcw.use_cases.operation.create;

import ru.lm359x.onlinebankcw.entity.Operation;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateOperationResponseModel {
    UUID id;

    public CreateOperationResponseModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
