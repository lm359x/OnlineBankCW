package ru.lm359x.onlinebankcw.use_cases.user.update;

import ru.lm359x.onlinebankcw.entity.User;
import ru.lm359x.onlinebankcw.entity.UserFactory;
import ru.lm359x.onlinebankcw.entity.UserFactoryImpl;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.util.Objects;
import java.util.UUID;

public class UpdateUserInteractor implements UpdateUserInputBoundary{
    final UpdateUserOutputBoundary updateUserOutputBoundary;
    final UserGateway userGateway;

    final UserFactory userFactory;

    public UpdateUserInteractor(UpdateUserOutputBoundary updateUserOutputBoundary, UserGateway userGateway) {
        this.updateUserOutputBoundary = updateUserOutputBoundary;
        this.userGateway = userGateway;
        userFactory = new UserFactoryImpl();
    }

    @Override
    public void execute(UpdateUserRequestModel requestModel) {
        User currentUser = userGateway.getUserById(requestModel.id);
        if(Objects.isNull(currentUser)){
            throw new UserUpdateFailedException("User not found by UUID "+ requestModel.id);
        }
        if(!Objects.isNull(requestModel.firstName)){
            currentUser.setFirstName(requestModel.firstName);
        }
        if(!Objects.isNull(requestModel.lastName)){
            currentUser.setFirstName(requestModel.lastName);
        }
        if(!Objects.isNull(requestModel.login)){
            currentUser.setFirstName(requestModel.login);
        }
        if(!Objects.isNull(requestModel.password)){
            currentUser.setFirstName(requestModel.password);
        }
        if(!Objects.isNull(requestModel.phoneNumber)){
            currentUser.setFirstName(requestModel.phoneNumber);
        }
        if(!currentUser.valid())
            throw new UserUpdateFailedException("Invalid user data given");
        UUID id = userGateway.updateUser(currentUser);
        if(Objects.isNull(id))
            throw new UserUpdateFailedException("Gateway could not update user");
        updateUserOutputBoundary.present(new UpdateUserResponseModel(id));
    }
}
