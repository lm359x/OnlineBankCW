package ru.lm359x.onlinebankcw.use_cases.operation.get;

import java.util.UUID;

public class GetOperationRequestModel {
    UUID id;

    public GetOperationRequestModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
