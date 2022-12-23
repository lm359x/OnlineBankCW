package ru.lm359x.onlinebankcw.use_cases.bank_account.update;

public class BankAccountUpdateFailedException extends RuntimeException{
    public BankAccountUpdateFailedException(String message) {
        super(message);
    }
}
