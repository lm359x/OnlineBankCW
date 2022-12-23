package ru.lm359x.onlinebankcw.use_cases.bank_account.create;

import ru.lm359x.onlinebankcw.use_cases.bank_account.get.GetBankAccountResponseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateBankAccountResponseModel {
    UUID id;

    public CreateBankAccountResponseModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
