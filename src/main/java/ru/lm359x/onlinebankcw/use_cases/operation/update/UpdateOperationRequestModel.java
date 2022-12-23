package ru.lm359x.onlinebankcw.use_cases.operation.update;

import ru.lm359x.onlinebankcw.entity.Operation;

import java.util.UUID;

public class UpdateOperationRequestModel {
    UUID id;
    Operation.Status status;

    public UpdateOperationRequestModel(UUID id, Operation.Status status) {
        this.id = id;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Operation.Status getStatus() {
        return status;
    }
}
