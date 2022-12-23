package ru.lm359x.onlinebankcw.use_cases.bank_account.get_all_by_user;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.use_cases.bank_account.get.GetBankAccountResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GetBankAccountsResponseModel {
    List<GetBankAccountResponseModel> responseModels = new ArrayList<>();

    public List<GetBankAccountResponseModel> getResponseModels() {
        return responseModels;
    }
}
