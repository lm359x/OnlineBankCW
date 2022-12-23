package ru.lm359x.onlinebankcw.use_cases.user.update;

public class UserUpdateFailedException extends RuntimeException{
    public UserUpdateFailedException(String message) {
        super(message);
    }
}
