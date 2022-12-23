package ru.lm359x.onlinebankcw.use_cases.operation;

import ru.lm359x.onlinebankcw.entity.Operation;

import java.util.List;
import java.util.UUID;

public interface OperationGateway {
    Operation getById(UUID id);
    List<Operation> getAllByAccount(UUID bankAccountId);
    UUID createOperation(Operation operation);

    UUID updateOperation(Operation operation);
}
