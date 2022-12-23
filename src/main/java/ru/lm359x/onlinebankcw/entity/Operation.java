package ru.lm359x.onlinebankcw.entity;

import java.time.LocalDateTime;

public interface Operation {
    Float getAmount();
    BankAccount getFrom();
    BankAccount getTo();
    Type getType();
    Status getStatus();
    LocalDateTime getCreationTime();

    void setStatus(Status status);
    
    void process();
    
    enum Type{
        INNER, OUTER, REPLENISHMENT
    }

    enum Status{
        HOLD, PROCESSING, PROCESSED
    }
}
