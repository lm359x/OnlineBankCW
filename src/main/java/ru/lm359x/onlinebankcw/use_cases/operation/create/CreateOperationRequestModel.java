package ru.lm359x.onlinebankcw.use_cases.operation.create;

import ru.lm359x.onlinebankcw.entity.Operation;

import java.util.UUID;

public class CreateOperationRequestModel {
    Float amount;
    UUID fromId;
    UUID toId;
    Operation.Type type;

    public CreateOperationRequestModel(Float amount, UUID fromId, UUID toId, Operation.Type type) {
        this.amount = amount;
        this.fromId = fromId;
        this.toId = toId;
        this.type = type;
    }

    public Float getAmount() {
        return amount;
    }

    public UUID getFromId() {
        return fromId;
    }

    public UUID getToId() {
        return toId;
    }

    public Operation.Type getType() {
        return type;
    }
}
