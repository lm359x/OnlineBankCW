package ru.lm359x.onlinebankcw.use_cases.operation.get_all_by_account;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.entity.User;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;
import ru.lm359x.onlinebankcw.use_cases.operation.OperationGateway;
import ru.lm359x.onlinebankcw.use_cases.operation.get.GetOperationResponseModel;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.util.List;
import java.util.Objects;

public class GetOperationsInteractor implements GetOperationsInputBoundary {
    final GetOperationsOutputBoundary getOperationsOutputBoundary;
    final OperationGateway operationGateway;
    final BankAccountGateway bankAccountGateway;

    public GetOperationsInteractor(GetOperationsOutputBoundary getOperationsOutputBoundary, OperationGateway operationGateway, BankAccountGateway bankAccountGateway) {
        this.getOperationsOutputBoundary = getOperationsOutputBoundary;
        this.operationGateway = operationGateway;
        this.bankAccountGateway = bankAccountGateway;
    }

    @Override
    public void execute(GetOperationsRequestModel requestModel) {
        BankAccount bankAccount = bankAccountGateway.getBankAccountById(requestModel.bankAccountId);
        if(Objects.isNull(bankAccount))
            throw new GetAllOperationsByUserException("Bank account is null");
        GetOperationsResponseModel responseModel = new GetOperationsResponseModel();
        List<Operation> operations = operationGateway.getAllByAccount(bankAccount.getId());
        for(Operation operation: operations){
            String from = "";
            String to = "";
            switch (operation.getType()){
                case INNER -> {
                    from = operation.getFrom().getNumber();
                    to = operation.getTo().getNumber();
                }
                case REPLENISHMENT -> {
                    from = "Some replenishment source";
                    to = operation.getTo().getNumber();
                }
                case OUTER -> {
                    from = operation.getFrom().getNumber();
                    to = "Some outer destination";
                }
            }
            responseModel.getResponseModels().add(new GetOperationResponseModel(
                    operation.getAmount(),
                    from,
                    to,
                    operation.getType(),
                    operation.getStatus(),
                    operation.getCreationTime()
            ));
        }
        getOperationsOutputBoundary.present(responseModel);
    }
}
