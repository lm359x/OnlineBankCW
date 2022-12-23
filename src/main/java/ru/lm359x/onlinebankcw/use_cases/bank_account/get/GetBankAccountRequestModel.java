package ru.lm359x.onlinebankcw.use_cases.bank_account.get;

import java.util.UUID;

public class GetBankAccountRequestModel {
    UUID id;
    String number;

    public GetBankAccountRequestModel(UUID id) {
        this.id = id;
        number = "";
    }

    public GetBankAccountRequestModel(String number) {
        this.number = number;
        id = null;
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
}
