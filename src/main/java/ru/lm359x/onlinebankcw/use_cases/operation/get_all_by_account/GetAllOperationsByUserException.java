package ru.lm359x.onlinebankcw.use_cases.operation.get_all_by_account;

public class GetAllOperationsByUserException extends RuntimeException{
    public GetAllOperationsByUserException(String message) {
        super(message);
    }
}
