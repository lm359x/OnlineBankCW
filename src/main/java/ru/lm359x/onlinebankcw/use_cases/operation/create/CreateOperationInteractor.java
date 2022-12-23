package ru.lm359x.onlinebankcw.use_cases.operation.create;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.entity.OperationFactory;
import ru.lm359x.onlinebankcw.entity.OperationFactoryImpl;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;
import ru.lm359x.onlinebankcw.use_cases.operation.OperationGateway;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CreateOperationInteractor implements CreateOperationInputBoundary {
    final CreateOperationOutputBoundary createOperationOutputBoundary;
    final OperationGateway operationGateway;
    final BankAccountGateway bankAccountGateway;
    final UserGateway userGateway;
    final OperationFactory operationFactory;

    public CreateOperationInteractor(CreateOperationOutputBoundary createOperationOutputBoundary, OperationGateway operationGateway, BankAccountGateway bankAccountGateway, UserGateway userGateway) {
        this.createOperationOutputBoundary = createOperationOutputBoundary;
        this.operationGateway = operationGateway;
        this.bankAccountGateway = bankAccountGateway;
        this.userGateway = userGateway;
        operationFactory = new OperationFactoryImpl();
    }

    @Override
    public void execute(CreateOperationRequestModel requestModel) {
        BankAccount from = bankAccountGateway.getBankAccountById(requestModel.fromId);
        BankAccount to = bankAccountGateway.getBankAccountById(requestModel.toId);
        Operation operation = operationFactory.create(requestModel.amount, from,to, requestModel.type, LocalDateTime.now());
        UUID id = operationGateway.createOperation(operation);
        if(Objects.isNull(id))
            throw new OperationCreationFailedException("Gateway returned null");
        from.addOperation(operation);
        to.addOperation(operation);
        bankAccountGateway.updateAccount(from);
        userGateway.updateUser(from.getUser());
        bankAccountGateway.updateAccount(to);
        userGateway.updateUser(to.getUser());
        CreateOperationResponseModel responseModel = new CreateOperationResponseModel(id);
        createOperationOutputBoundary.present(responseModel);
    }
}
