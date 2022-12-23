package ru.lm359x.onlinebankcw.use_cases.user.get_all;

public class GetUsersRequestModel {
    Integer limit;
    String sortedBy;

    public GetUsersRequestModel(Integer limit, String sortedBy) {
        this.limit = limit;
        this.sortedBy = sortedBy;
    }
}
