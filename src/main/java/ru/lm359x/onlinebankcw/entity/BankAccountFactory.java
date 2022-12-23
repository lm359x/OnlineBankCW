package ru.lm359x.onlinebankcw.entity;

public interface BankAccountFactory {
    BankAccount create(BankAccount.BankAccountType type, String number, Float balance, Float limit, User user);
    BankAccount create(BankAccount.BankAccountType type, String number, Float balance, User user);

    BankAccount create(BankAccount.BankAccountType type, User user);

}
