package ru.lm359x.onlinebankcw.use_cases.bank_account.create;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.BankAccountFactory;
import ru.lm359x.onlinebankcw.entity.BankAccountFactoryImpl;
import ru.lm359x.onlinebankcw.entity.User;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;

import java.util.Objects;
import java.util.UUID;

public class CreateBankAccountInteractor implements CreateBankAccountInputBoundary {
    final CreateBankAccountOutputBoundary createBankAccountOutputBoundary;
    final BankAccountGateway bankAccountGateway;
    final UserGateway userGateway;
    final BankAccountFactory bankAccountFactory;

    public CreateBankAccountInteractor(CreateBankAccountOutputBoundary createBankAccountOutputBoundary, BankAccountGateway bankAccountGateway, UserGateway userGateway) {
        this.createBankAccountOutputBoundary = createBankAccountOutputBoundary;
        this.bankAccountGateway = bankAccountGateway;
        this.userGateway = userGateway;
        bankAccountFactory = new BankAccountFactoryImpl();
    }

    @Override
    public void execute(CreateBankAccountRequestModel requestModel) {
        User user = userGateway.getUserById(requestModel.userId);
        if(Objects.isNull(user))
            throw new BankAccountCreationFailedException("User UUID is null");
        BankAccount bankAccount = bankAccountFactory.create(requestModel.type,user);
        UUID bankAccountId = bankAccountGateway.createAccount(bankAccount);
        if(Objects.isNull(bankAccountId))
            throw new BankAccountCreationFailedException("Gateway returned null");
        user.addAccount(bankAccountGateway.getBankAccountById(bankAccountId));
        userGateway.updateUser(user);
        CreateBankAccountResponseModel responseModel = new CreateBankAccountResponseModel(bankAccountId);
        createBankAccountOutputBoundary.present(responseModel);
    }
}
