package ru.lm359x.onlinebankcw.use_cases.user.get;

import ru.lm359x.onlinebankcw.entity.BankAccount;
import ru.lm359x.onlinebankcw.entity.Operation;
import ru.lm359x.onlinebankcw.entity.User;

import java.util.List;
import java.util.UUID;


public class GetUserResponseModel {
    UUID id;
    String firstName;
    String lastName;
    String login;
    String phoneNumber;
    List<Operation> operations;
    List<BankAccount> bankAccounts;

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public GetUserResponseModel(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.login = user.getLogin();
        this.phoneNumber = user.getPhoneNumber();
        this.operations = user.getOperations();
        this.bankAccounts = user.getBankAccounts();
    }
}
