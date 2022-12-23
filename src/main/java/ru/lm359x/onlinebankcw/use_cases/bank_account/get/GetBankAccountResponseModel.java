package ru.lm359x.onlinebankcw.use_cases.bank_account.get;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;

import java.util.List;
import java.util.UUID;

public class GetBankAccountResponseModel {
    UUID id;
    BankAccount.BankAccountType type;
    String number;
    Float balance;
    Float limit;
    String userLogin;
    List<Operation> operations;
    Boolean active;

    public GetBankAccountResponseModel(UUID id, BankAccount.BankAccountType type, String number, Float balance, Float limit, String userLogin, List<Operation> operations, Boolean active) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.balance = balance;
        this.limit = limit;
        this.userLogin = userLogin;
        this.operations = operations;
        this.active = active;
    }
}
