package ru.lm359x.onlinebankcw.entity;

import java.time.LocalDateTime;

public class OperationFactoryImpl implements OperationFactory{
    @Override
    public Operation create(Float amount, BankAccount from, BankAccount to, Operation.Type type, LocalDateTime creationTime) {
        return new OperationImpl(amount, from, to, type, creationTime);
    }
}
