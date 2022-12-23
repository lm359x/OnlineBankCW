package ru.lm359x.onlinebankcw.use_cases.bank_account.update;

import java.util.UUID;

public class UpdateBankAccountResponseModel {
    UUID id;

    public UpdateBankAccountResponseModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
