package ru.lm359x.onlinebankcw.use_cases.operation.get;

import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.use_cases.operation.OperationGateway;

import java.util.Objects;

public class GetOperationInteractor implements GetOperationInputBoundary{
    final GetOperationOutputBoundary getOperationOutputBoundary;
    final OperationGateway operationGateway;

    public GetOperationInteractor(GetOperationOutputBoundary getOperationOutputBoundary, OperationGateway operationGateway) {
        this.getOperationOutputBoundary = getOperationOutputBoundary;
        this.operationGateway = operationGateway;
    }

    @Override
    public void execute(GetOperationRequestModel requestModel) {
        Operation operation = operationGateway.getById(requestModel.id);
        if(Objects.isNull(operation))
            throw new OperationNotFoundException();
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
        GetOperationResponseModel responseModel = new GetOperationResponseModel(
                operation.getAmount(),
                from,
                to,
                operation.getType(),
                operation.getStatus(),
                operation.getCreationTime()
        );
        getOperationOutputBoundary.present(responseModel);
    }
}
