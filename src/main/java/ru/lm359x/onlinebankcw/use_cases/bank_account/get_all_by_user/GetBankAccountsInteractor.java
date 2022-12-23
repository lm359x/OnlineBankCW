package ru.lm359x.onlinebankcw.use_cases.bank_account.get_all_by_user;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;
import ru.lm359x.onlinebankcw.use_cases.bank_account.get.GetBankAccountResponseModel;

import java.util.Objects;

public class GetBankAccountsInteractor implements GetBankAccountsInputBoundary {
    final GetBankAccountsOutputBoundary getBankAccountsOutputBoundary;
    final BankAccountGateway bankAccountGateway;

    public GetBankAccountsInteractor(GetBankAccountsOutputBoundary getBankAccountsOutputBoundary, BankAccountGateway bankAccountGateway) {
        this.getBankAccountsOutputBoundary = getBankAccountsOutputBoundary;
        this.bankAccountGateway = bankAccountGateway;
    }

    @Override
    public void execute(GetBankAccountsRequestModel requestModel) {
        GetBankAccountsResponseModel responseModel = new GetBankAccountsResponseModel();
        bankAccountGateway.getBankAccountsByUser(requestModel.id).forEach(
                bankAccount -> responseModel.responseModels.add(new GetBankAccountResponseModel(
                        bankAccount.getId(),
                        bankAccount.getType(),
                        bankAccount.getNumber(),
                        bankAccount.getBalance(),
                        bankAccount.getLimit(),
                        bankAccount.getUser().getLogin(),
                        bankAccount.getOperations(),
                        bankAccount.getActive()
                ))
        );
        getBankAccountsOutputBoundary.present(responseModel);
    }
}
