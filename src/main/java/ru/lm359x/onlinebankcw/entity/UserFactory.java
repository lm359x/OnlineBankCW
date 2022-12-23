package ru.lm359x.onlinebankcw.entity;

public interface UserFactory {
    User create(String firstName, String lastName, String login, String password,String phoneNumber);
}
