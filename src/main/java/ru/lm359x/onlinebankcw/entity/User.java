package ru.lm359x.onlinebankcw.entity;

import java.util.List;
import java.util.UUID;

public interface User {
    UUID getId();
    String getFirstName();
    String getLastName();
    String getLogin();
    String getPassword();

    String getPhoneNumber();
    List<Operation> getOperations();
    List<BankAccount> getBankAccounts();

    void setId(UUID id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setLogin(String login);
    void setPassword(String password);
    void setPhoneNumber(String phoneNumber);
    void setOperations(List<Operation> operations);
    void setBankAccounts(List<BankAccount> bankAccounts);

    void addAccount(BankAccount account);

    boolean valid();
}
