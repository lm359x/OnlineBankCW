package ru.lm359x.onlinebankcw.use_cases.operation.get;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;

import java.time.LocalDateTime;

public class GetOperationResponseModel {
    Float amount;
    String from;
    String to;
    Operation.Type type;
    Operation.Status status;
    LocalDateTime creationTime;

    public GetOperationResponseModel(Float amount, String from, String to, Operation.Type type, Operation.Status status, LocalDateTime creationTime) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.type = type;
        this.status = status;
        this.creationTime = creationTime;
    }

    public Float getAmount() {
        return amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Operation.Type getType() {
        return type;
    }

    public Operation.Status getStatus() {
        return status;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
