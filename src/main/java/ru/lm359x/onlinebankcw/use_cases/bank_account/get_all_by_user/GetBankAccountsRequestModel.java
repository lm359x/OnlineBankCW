package ru.lm359x.onlinebankcw.use_cases.bank_account.get_all_by_user;

import java.util.UUID;

public class GetBankAccountsRequestModel {
    UUID id;

    public GetBankAccountsRequestModel(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
