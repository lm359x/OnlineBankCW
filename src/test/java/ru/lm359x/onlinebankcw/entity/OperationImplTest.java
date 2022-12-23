package ru.lm359x.onlinebankcw.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationImplTest {
    static OperationFactory operationFactory = new OperationFactoryImpl();
    static BankAccountFactory bankAccountFactory = new BankAccountFactoryImpl();
    static BankAccount to;
    static BankAccount from;
    @BeforeEach
    void init(){
        to = bankAccountFactory.create(BankAccount.BankAccountType.DEBIT,null,0f,null);
        from = bankAccountFactory.create(BankAccount.BankAccountType.DEBIT,null,0f,null);
    }

    @Test
    void processInner(){
        Operation operation = operationFactory.create(1000f,from,to, Operation.Type.INNER,null);
        operation.process();
        assertEquals(-1000,from.getBalance());
        assertEquals(1000,to.getBalance());
    }

    @Test
    void processOuter(){
        Operation operation = operationFactory.create(1000f,from,to, Operation.Type.OUTER,null);
        operation.process();
        assertEquals(-1000,from.getBalance());
        assertEquals(0,to.getBalance());
    }

    @Test
    void processReplenishment(){
        Operation operation = operationFactory.create(1000f,from,to, Operation.Type.REPLENISHMENT,null);
        operation.process();
        assertEquals(0,from.getBalance());
        assertEquals(1000,to.getBalance());
    }
}