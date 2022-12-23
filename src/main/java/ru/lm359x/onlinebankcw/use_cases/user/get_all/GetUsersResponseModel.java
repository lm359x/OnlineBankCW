package ru.lm359x.onlinebankcw.use_cases.user.get_all;

import ru.lm359x.onlinebankcw.use_cases.user.get.GetUserResponseModel;

import java.util.List;


public class GetUsersResponseModel {
    List<GetUserResponseModel> users;

    public List<GetUserResponseModel> getUsers() {
        return users;
    }

    public GetUsersResponseModel(List<GetUserResponseModel> users) {
        this.users = users;
    }
}
