package ru.lm359x.onlinebankcw.use_cases.operation.update;

import ru.lm359x.onlinebankcw.entity.*;
import ru.lm359x.onlinebankcw.use_cases.bank_account.BankAccountGateway;
import ru.lm359x.onlinebankcw.use_cases.operation.OperationGateway;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class UpdateOperationInteractor implements UpdateOperationInputBoundary {
    final UpdateOperationOutputBoundary updateOperationOutputBoundary;
    final OperationGateway operationGateway;
    final BankAccountGateway bankAccountGateway;
    final OperationFactory operationFactory;

    public UpdateOperationInteractor(UpdateOperationOutputBoundary updateOperationOutputBoundary, OperationGateway operationGateway, BankAccountGateway bankAccountGateway) {
        this.updateOperationOutputBoundary = updateOperationOutputBoundary;
        this.operationGateway = operationGateway;
        this.bankAccountGateway = bankAccountGateway;
        operationFactory = new OperationFactoryImpl();
    }

    @Override
    public void execute(UpdateOperationRequestModel requestModel) {
        Operation operation = operationGateway.getById(requestModel.id);
        if(Objects.isNull(operation))
            throw new OperationUpdateFailedException("User is null");
        if(Objects.isNull(requestModel.status))
            throw new OperationUpdateFailedException("Status is null");
        operation.setStatus(requestModel.status);
        if(requestModel.status.equals(Operation.Status.PROCESSED)) {
            operation.process();
            bankAccountGateway.updateAccount(operation.getFrom());
            bankAccountGateway.updateAccount(operation.getTo());
        }
        UUID id = operationGateway.updateOperation(operation);
        if(Objects.isNull(id))
            throw new OperationUpdateFailedException("Gateway returned null");
        UpdateOperationResponseModel responseModel = new UpdateOperationResponseModel(id);
        updateOperationOutputBoundary.present(responseModel);
    }
}
