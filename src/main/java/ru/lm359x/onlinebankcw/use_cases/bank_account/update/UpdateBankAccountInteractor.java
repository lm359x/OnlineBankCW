package ru.lm359x.onlinebankcw.use_cases.bank_account.update;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.BankAccountFactory;
import ru.lm359x.onlinebankcw.entity.BankAccountFactoryImpl;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;

import java.util.Objects;
import java.util.UUID;

public class UpdateBankAccountInteractor implements UpdateBankAccountInputBoundary {
    final UpdateBankAccountOutputBoundary updateBankAccountOutputBoundary;
    final BankAccountGateway bankAccountGateway;
    final UserGateway userGateway;
    final BankAccountFactory bankAccountFactory;

    public UpdateBankAccountInteractor(UpdateBankAccountOutputBoundary updateBankAccountOutputBoundary, BankAccountGateway bankAccountGateway, UserGateway userGateway) {
        this.updateBankAccountOutputBoundary = updateBankAccountOutputBoundary;
        this.bankAccountGateway = bankAccountGateway;
        this.userGateway = userGateway;
        bankAccountFactory = new BankAccountFactoryImpl();
    }

    @Override
    public void execute(UpdateBankAccountRequestModel requestModel) {
        BankAccount bankAccount = bankAccountGateway.getBankAccountById(requestModel.id);
        if (Objects.isNull(bankAccount))
            throw new BankAccountUpdateFailedException("Bank account not found by UUID "+requestModel.id);
        if (!Objects.isNull(requestModel.number)){
            bankAccount.setNumber(requestModel.number);
        }
        if(!bankAccount.validNumber())
            throw new BankAccountUpdateFailedException("Given number is invalid");
        if (!Objects.isNull(requestModel.balance)){
            bankAccount.setBalance(requestModel.balance);
        }
        if (!Objects.isNull(requestModel.limit)){
            bankAccount.setLimit(requestModel.limit);
        }
        if (!Objects.isNull(requestModel.active)){
            bankAccount.setActive(requestModel.active);
        }
        UUID id = bankAccountGateway.updateAccount(bankAccount);
        if(Objects.isNull(id))
            throw new BankAccountUpdateFailedException("Gateway could not update bank account");
        updateBankAccountOutputBoundary.present(new UpdateBankAccountResponseModel(id));
    }
}
