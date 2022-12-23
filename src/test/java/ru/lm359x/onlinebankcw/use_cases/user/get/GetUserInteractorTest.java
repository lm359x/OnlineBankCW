package ru.lm359x.onlinebankcw.use_cases.user.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.lm359x.onlinebankcw.entity.User;
import ru.lm359x.onlinebankcw.entity.UserFactory;
import ru.lm359x.onlinebankcw.entity.UserFactoryImpl;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GetUserInteractorTest {
    UserGateway getUserGateway;
    GetUserOutputBoundary getUserOutputBoundary;
    GetUserInteractor getUserInteractor;

    @BeforeEach
    void init(){
        getUserGateway = mock(UserGateway.class);
        getUserOutputBoundary = mock(GetUserOutputBoundary.class);
        when(getUserOutputBoundary.presentView(any())).thenAnswer(i->i.getArguments()[0]);
        getUserInteractor = new GetUserInteractor(getUserGateway,getUserOutputBoundary);
    }

    @Test
    void givenNull_whenExecute_ThenExceptionThrown() {
        GetUserRequestModel requestModel = null;
        assertThrows(UserNotFoundException.class,()->getUserInteractor.execute(requestModel));
    }
    @Test
    void givenNullType_whenExecute_ThenThrown(){
        GetUserRequestModel requestModel = new GetUserRequestModel("jamesjameson","9999999999", UUID.fromString("b404eac4-16af-4f81-8ccf-ee10f5668f1b"),null);
        assertThrows(UserNotFoundException.class,()->getUserInteractor.execute(requestModel));
    }
    @Test
    void givenValidRequest_whenExecute_ThenValidResponse(){
        GetUserRequestModel requestModel = new GetUserRequestModel("jamesjameson","9999999999", UUID.fromString("b404eac4-16af-4f81-8ccf-ee10f5668f1b"), GetUserRequestModel.QueryType.ID);
        UserFactory userFactory = new UserFactoryImpl();
        User user = userFactory.create("James", "Jameson","jamesjameson","supersecretpass","9999999999");
        user.setId(UUID.fromString("b404eac4-16af-4f81-8ccf-ee10f5668f1b"));
        when(getUserGateway.getUserById(UUID.fromString("b404eac4-16af-4f81-8ccf-ee10f5668f1b"))).thenReturn(user);
        getUserInteractor.execute(requestModel);
        verify(getUserOutputBoundary).presentView(any());
    }

}