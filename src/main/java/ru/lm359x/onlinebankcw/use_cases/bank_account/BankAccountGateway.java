package ru.lm359x.onlinebankcw.use_cases.bank_account;

import ru.lm359x.onlinebankcw.entity.BankAccount;

import java.util.List;
import java.util.UUID;

public interface BankAccountGateway {
    BankAccount getBankAccountById(UUID id);
    BankAccount getBankAccountByNumber(String number);

    List<BankAccount> getBankAccountsByUser(UUID id);

    UUID createAccount(BankAccount bankAccount);

    UUID updateAccount(BankAccount bankAccount);
}
