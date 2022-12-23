package ru.lm359x.onlinebankcw.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BankAccountImpl implements BankAccount {
    UUID id;
    BankAccountType type;
    String number;
    Float balance;
    Float limit;
    User user;
    List<Operation> operations;
    Boolean active;

    BankAccountImpl(BankAccountType type, User user){
        this(type,"",0f,0f,user);
    }

    BankAccountImpl(BankAccountType type, String number, Float balance, User user) {
        this(type,number,balance,0f,user);
    }

    BankAccountImpl(BankAccountType type, String number, Float balance, Float limit, User user) {
        this.type = type;
        this.number = number;
        this.balance = balance;
        if (this.type.equals(BankAccountType.DEBIT)) {
            this.limit = 0f;
        }
        else {
            this.limit = limit;
        }
        this.user = user;
        operations = new ArrayList<>();
        this.active = true;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public BankAccountType getType() {
        return type;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Float getBalance() {
        return balance;
    }

    @Override
    public Float getLimit() {
        return limit;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public Boolean getActive() {
        return active;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public void addOperation(Operation operation) {
        if(!Objects.isNull(operation)) {
            operations.add(operation);
            user.getOperations().add(operation);
        }
    }

    @Override
    public void setLimit(Float limit) {
        if(type==BankAccountType.CREDIT)
            this.limit=limit;
    }

    @Override
    public boolean validNumber() {
        Matcher m = Pattern.compile("(\\d{4}-){3}\\d{4}").matcher(number);
        return m.matches();
    }

}
