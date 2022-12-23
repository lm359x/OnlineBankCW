package ru.lm359x.onlinebankcw.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserImpl implements User{
    UUID id;
    String firstName;
    String lastName;
    String login;
    String password;

    String phoneNumber;
    List<Operation> operations;
    List<BankAccount> bankAccounts;

    UserImpl(String firstName, String lastName, String login, String password,String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phoneNumber=phoneNumber;
        this.id = null;
        operations = new ArrayList<>();
        bankAccounts = new ArrayList<>();
    }

    @Override
    public void addAccount(BankAccount account) {
        if(!Objects.isNull(account))bankAccounts.add(account);
    }

    @Override
    public boolean valid() {
        Matcher m = Pattern.compile("\\d{10}").matcher(phoneNumber);
        return password.length()>7 && login.length()>5 && m.matches();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
