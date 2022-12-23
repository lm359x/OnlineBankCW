package ru.lm359x.onlinebankcw.entity;

import java.util.List;
import java.util.UUID;

public interface BankAccount {
    UUID getId();
    BankAccountType getType();
    String getNumber();
    Float getBalance();

    Float getLimit();
    User getUser();
    List<Operation> getOperations();
    Boolean getActive();
    void setId(UUID id);
    void setNumber(String number);
    void setActive(Boolean active);
    void setBalance(Float balance);
    void addOperation(Operation operation);

    void setLimit(Float limit);
    boolean validNumber();


    enum BankAccountType{
        DEBIT,
        CREDIT
    }
}
