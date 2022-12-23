package ru.lm359x.onlinebankcw.use_cases.operation.get_all_by_account;

import ru.lm359x.onlinebankcw.use_cases.operation.get.GetOperationResponseModel;

import java.util.List;

public class GetOperationsResponseModel {
    List<GetOperationResponseModel> responseModels;

    public List<GetOperationResponseModel> getResponseModels() {
        return responseModels;
    }
}
