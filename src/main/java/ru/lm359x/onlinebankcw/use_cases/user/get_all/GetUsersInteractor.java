package ru.lm359x.onlinebankcw.use_cases.user.get_all;

import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;
import ru.lm359x.onlinebankcw.use_cases.user.get.GetUserResponseModel;

import java.util.ArrayList;

public class GetUsersInteractor implements GetUsersInputBoundary {
    final UserGateway userGateway;
    final GetUsersOutputBoundary usersOutputBoundary;

    public GetUsersInteractor(UserGateway userGateway, GetUsersOutputBoundary usersOutputBoundary) {
        this.userGateway = userGateway;
        this.usersOutputBoundary = usersOutputBoundary;
    }

    @Override
    public void execute(GetUsersRequestModel requestModel) {
        GetUsersResponseModel responseModel = new GetUsersResponseModel(new ArrayList<>());
        userGateway.getUsers(requestModel.limit, requestModel.sortedBy).forEach(u->
            responseModel.users.add(new GetUserResponseModel(u))
        );
        usersOutputBoundary.presentView(responseModel);
    }
}
