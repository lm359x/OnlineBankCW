package ru.lm359x.onlinebankcw.use_cases.user.create;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateUserInteractorTest {
    UserGateway userGateway;
    CreateUserOutputBoundary createUserOutputBoundary;
    CreateUserInteractor createUserInteractor;

    @BeforeEach
    void init(){
        userGateway = mock(UserGateway.class);
        when(userGateway.createUser(any())).thenReturn(UUID.randomUUID());
        createUserOutputBoundary = mock(CreateUserOutputBoundary.class);
        when(createUserOutputBoundary.presentView(any())).thenReturn(null);
        createUserInteractor = new CreateUserInteractor(createUserOutputBoundary,userGateway);
    }
    @Test
    void givenNullField_whenExecute_thenUserCreationFailedException() {
        CreateUserRequestModel requestModel = new CreateUserRequestModel(null,"James","jamesjameson","secretpass","9999999999");
        UserCreationFailedException thrown = Assertions.assertThrows(UserCreationFailedException.class,()->
                createUserInteractor.execute(requestModel),"Received null parameter: firstName");
    }
    @Test
    void givenInvalidUserField_whenExecute_thenUserCreationFailedException() {
        CreateUserRequestModel requestModel = new CreateUserRequestModel("James","James","1","secretpass","9999999999");
        UserCreationFailedException thrown = Assertions.assertThrows(UserCreationFailedException.class,()->
                createUserInteractor.execute(requestModel),"Invalid user data");
    }
    @Test
    void givenValidParam_whenExecute_thenNotThrown() {
        CreateUserRequestModel requestModel = new CreateUserRequestModel("James","Jameson","jamesjameson","secretpass","9999999999");
        assertDoesNotThrow(()->createUserInteractor.execute(requestModel));
    }
}