package ru.lm359x.onlinebankcw.use_cases.user.get;

import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;
import ru.lm359x.onlinebankcw.entity.*;

import java.util.Objects;

public class GetUserInteractor implements GetUserInputBoundary {
    private final UserGateway getUserGateway;
    private final GetUserOutputBoundary getUserOutputBoundary;

//    private GetUserResponseModel getUserResponseModel;

    public GetUserInteractor(UserGateway getUserGateway, GetUserOutputBoundary getUserOutputBoundary
//                             ,GetUserResponseModel getUserResponseModel
    ) {

        this.getUserGateway = getUserGateway;
        this.getUserOutputBoundary = getUserOutputBoundary;
//        this.getUserResponseModel = getUserResponseModel;
    }


    @Override
    public void execute(GetUserRequestModel requestModel) {
        User user = null;
        try{
            switch (requestModel.type) {
                case ID -> user = getUserGateway.getUserById(requestModel.id);
                case LOGIN -> user = getUserGateway.getUserByLogin(requestModel.login);
                case PHONE_NUMBER -> user = getUserGateway.getUserByPhoneNumber(requestModel.phoneNumber);
            }
        }catch(NullPointerException e){
            throw new UserNotFoundException("Null pointer");
        }
        if(Objects.isNull(user)){
            throw new UserNotFoundException("Gateway returned null");
        }
        GetUserResponseModel responseModel = new GetUserResponseModel(user);
        getUserOutputBoundary.presentView(responseModel);
    }
}
