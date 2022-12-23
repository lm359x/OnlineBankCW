package ru.lm359x.onlinebankcw.use_cases.operation.get_all_by_account;

import java.util.UUID;

public class GetOperationsRequestModel {
    UUID bankAccountId;

    public GetOperationsRequestModel(UUID bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public UUID getBankAccountId() {
        return bankAccountId;
    }
}
