package ru.lm359x.onlinebankcw.use_cases.bank_account.update;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.entity.User;

import java.util.List;
import java.util.UUID;

public class UpdateBankAccountRequestModel {
    UUID id;
    String number;
    Float balance;
    Float limit;
    Boolean active;
}
