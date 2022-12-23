package ru.lm359x.onlinebankcw.use_cases.user.create;

import ru.lm359x.onlinebankcw.entity.User;
import ru.lm359x.onlinebankcw.entity.UserFactory;
import ru.lm359x.onlinebankcw.entity.UserFactoryImpl;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.UUID;

public class CreateUserInteractor implements CreateUserInputBoundary{
    final CreateUserOutputBoundary createUserOutputBoundary;
    final UserGateway userGateway;

    final UserFactory userFactory;

    public CreateUserInteractor(CreateUserOutputBoundary createUserOutputBoundary, UserGateway userGateway) {
        this.createUserOutputBoundary = createUserOutputBoundary;
        this.userGateway = userGateway;
        userFactory = new UserFactoryImpl();
    }

    @Override
    public void execute(CreateUserRequestModel requestModel) throws IllegalAccessException {
        Field[] requestModelFields = requestModel.getClass().getDeclaredFields();
        for(Field f: requestModelFields){
            try {
                if(Objects.isNull(f.get(requestModel))){
                    throw new UserCreationFailedException("Received null parameter: "+f.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        User user = userFactory.create(requestModel.firstName, requestModel.lastName, requestModel.getLogin(), requestModel.password, requestModel.phoneNumber);
        if(!user.valid())
            throw new UserCreationFailedException("Invalid user data");
        UUID id = userGateway.createUser(user);
        if(Objects.isNull(id))
            throw new UserCreationFailedException("UUID is null");
        CreateUserResponseModel responseModel = new CreateUserResponseModel(id);
        createUserOutputBoundary.presentView(responseModel);
    }
}
