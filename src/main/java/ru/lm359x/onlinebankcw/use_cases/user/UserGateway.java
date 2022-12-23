package ru.lm359x.onlinebankcw.use_cases.user;

import org.springframework.stereotype.Service;
import ru.lm359x.onlinebankcw.entity.User;

import java.util.List;
import java.util.UUID;

@Service
public interface UserGateway {
    User getUserById(UUID id);
    User getUserByLogin(String id);
    User getUserByPhoneNumber(String phoneNumber);
    List<User> getUsers(Integer limit, String sortedBy);

    UUID createUser(User user);

    UUID updateUser(User user);
}
