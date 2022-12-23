package ru.lm359x.onlinebankcw.entity;

import java.time.LocalDateTime;

public interface OperationFactory {
    Operation create(Float amount, BankAccount from, BankAccount to, Operation.Type type, LocalDateTime creationTime);
}
