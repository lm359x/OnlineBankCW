package ru.lm359x.onlinebankcw.entity;

public class UserFactoryImpl implements UserFactory{
    @Override
    public User create(String firstName, String lastName, String login, String password,String phoneNumber) {
        return new UserImpl(firstName, lastName, login, password,phoneNumber);
    }
}
