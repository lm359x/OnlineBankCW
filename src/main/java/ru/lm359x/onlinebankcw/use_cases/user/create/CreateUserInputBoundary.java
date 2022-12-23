package ru.lm359x.onlinebankcw.use_cases.user.create;

public interface CreateUserInputBoundary {
    void execute(CreateUserRequestModel requestModel) throws IllegalAccessException;
}
