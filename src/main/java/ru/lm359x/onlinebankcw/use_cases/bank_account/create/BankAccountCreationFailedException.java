package ru.lm359x.onlinebankcw.use_cases.bank_account.create;

public class BankAccountCreationFailedException extends RuntimeException{
    public BankAccountCreationFailedException(String message) {
        super(message);
    }
}
