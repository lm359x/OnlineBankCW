package ru.lm359x.onlinebankcw.use_cases.user.get;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}

