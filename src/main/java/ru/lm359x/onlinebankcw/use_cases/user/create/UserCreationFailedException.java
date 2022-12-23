package ru.lm359x.onlinebankcw.use_cases.user.create;

public class UserCreationFailedException extends RuntimeException{
    public UserCreationFailedException(String message) {
        super(message);
    }
}
