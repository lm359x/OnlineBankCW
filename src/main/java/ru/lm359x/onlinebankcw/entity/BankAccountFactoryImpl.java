package ru.lm359x.onlinebankcw.entity;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount create(BankAccount.BankAccountType type, String number, Float balance, Float limit, User user) {
        return new BankAccountImpl(type, number, balance, limit, user);
    }

    @Override
    public BankAccount create(BankAccount.BankAccountType type, String number, Float balance, User user) {
        return new BankAccountImpl(type, number, balance, user);
    }

    @Override
    public BankAccount create(BankAccount.BankAccountType type, User user) {
        return new BankAccountImpl(type,user);
    }
}
