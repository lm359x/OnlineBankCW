package ru.lm359x.onlinebankcw.use_cases.bank_account.create;

import ru.lm359x.onlinebankcw.entity.BankAccount;

import java.util.UUID;

public class CreateBankAccountRequestModel {
    BankAccount.BankAccountType type;
    UUID userId;


    public CreateBankAccountRequestModel(BankAccount.BankAccountType type, String number, Float balance, UUID userId) {
        this.type = type;
        this.userId = userId;
    }

    public BankAccount.BankAccountType getType() {
        return type;
    }

    public UUID getUserId() {
        return userId;
    }
}
