package ru.lm359x.onlinebankcw.use_cases.bank_account.get;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;

import java.util.Objects;

public class GetBankAccountInteractor implements GetBankAccountInputBoundary{
    final GetBankAccountOutputBoundary getBankAccountOutputBoundary;
    final BankAccountGateway bankAccountGateway;

    public GetBankAccountInteractor(GetBankAccountOutputBoundary getBankAccountOutputBoundary, BankAccountGateway bankAccountGateway) {
        this.getBankAccountOutputBoundary = getBankAccountOutputBoundary;
        this.bankAccountGateway = bankAccountGateway;
    }

    @Override
    public void execute(GetBankAccountRequestModel requestModel) {
        BankAccount bankAccount = null;
        if(!Objects.isNull(requestModel.id)) {
            bankAccount = bankAccountGateway.getBankAccountById(requestModel.id);
        }
        else {
            bankAccount = bankAccountGateway.getBankAccountByNumber(requestModel.number);
        }
        if(Objects.isNull(bankAccount))
            throw new BankAccountNotFoundException();
        GetBankAccountResponseModel responseModel = new GetBankAccountResponseModel(
                bankAccount.getId(),
                bankAccount.getType(),
                bankAccount.getNumber(),
                bankAccount.getBalance(),
                bankAccount.getLimit(),
                bankAccount.getUser().getLogin(),
                bankAccount.getOperations(),
                bankAccount.getActive()
        );
        getBankAccountOutputBoundary.present(responseModel);
    }
}
