package ru.lm359x.onlinebankcw.use_cases.user.get_all;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.lm359x.onlinebankcw.entity.UserFactory;
import ru.lm359x.onlinebankcw.entity.UserFactoryImpl;
import ru.lm359x.onlinebankcw.entity.UserImpl;
import ru.lm359x.onlinebankcw.use_cases.user.UserGateway;
import ru.lm359x.onlinebankcw.use_cases.user.get.GetUserResponseModel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetUsersInteractorTest {
    UserGateway gateway;
    GetUsersOutputBoundary boundary;
    GetUsersInteractor interactor;

    @BeforeEach
    void init(){
        gateway = mock(UserGateway.class);
        boundary = mock(GetUsersOutputBoundary.class);
        interactor = new GetUsersInteractor(gateway,boundary);
    }
    @Test
    void execute(){

    }
}