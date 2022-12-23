package ru.lm359x.onlinebankcw.entity;

import java.time.LocalDateTime;

public class OperationImpl implements Operation {
    Float amount;
    BankAccount from;
    BankAccount to;
    Type type;
    Status status;
    LocalDateTime creationTime;

    OperationImpl(Float amount, BankAccount from, BankAccount to, Type type, LocalDateTime creationTime) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.type = type;
        this.status = Status.PROCESSING;
        this.creationTime = creationTime;
    }

    @Override
    public Float getAmount() {
        return amount;
    }

    @Override
    public BankAccount getFrom() {
        return from;
    }

    @Override
    public BankAccount getTo() {
        return to;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void process() {
        switch (type) {
            case INNER -> {
                from.setBalance(from.getBalance() - amount);
                to.setBalance(to.getBalance() + amount);
            }
            case OUTER -> from.setBalance(from.getBalance()- amount);
            case REPLENISHMENT -> to.setBalance(to.getBalance() + amount);
        }
    }
}
