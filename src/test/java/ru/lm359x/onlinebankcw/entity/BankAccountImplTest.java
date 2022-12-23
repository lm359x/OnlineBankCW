package ru.lm359x.onlinebankcw.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountImplTest {

    static BankAccountFactory factory = new BankAccountFactoryImpl();

    @BeforeAll
    static void init(){

    }
    @Test
    void givenValidNumber_whenValidNumber_ThenTrue() {
        BankAccount bankAccount = factory.create(BankAccount.BankAccountType.DEBIT,"1111-1111-1111-1111",0f,null);
        assertTrue(bankAccount.validNumber());
    }

    @Test
    void givenInvalidNumbers_whenValidNumber_ThenFalse(){
        assertFalse(factory.create(BankAccount.BankAccountType.DEBIT,"1111-1111-1111-",0f,null).validNumber());
        assertFalse(factory.create(BankAccount.BankAccountType.DEBIT,"1111-1111-1111-asdf",0f,null).validNumber());
        assertFalse(factory.create(BankAccount.BankAccountType.DEBIT,"1111-1111-1111-1111-",0f,null).validNumber());
    }

    @Test
    void givenDebit_whenSetLimit_thenBalanceEquals0(){
        BankAccount bankAccount = factory.create(BankAccount.BankAccountType.DEBIT,null,100f,null);
        assertEquals(0,bankAccount.getLimit());
        bankAccount.setBalance(1f);
        assertEquals(0,bankAccount.getLimit());
    }
}