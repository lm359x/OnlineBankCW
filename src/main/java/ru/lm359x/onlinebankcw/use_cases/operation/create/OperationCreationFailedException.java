package ru.lm359x.onlinebankcw.use_cases.operation.create;

public class OperationCreationFailedException extends RuntimeException{
    public OperationCreationFailedException(String message) {
        super(message);
    }
}
