package ru.lm359x.onlinebankcw.use_cases.operation.update;

public class OperationUpdateFailedException extends RuntimeException{
    public OperationUpdateFailedException(String message) {
        super(message);
    }
}
