package ru.lm359x.onlinebankcw.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {

    @Test
    void givenValid_whenValid_thenTrue() {
        User user = new UserImpl("James", "Jameson","jamesjameson","supersecretpass","9999999999");
        assertTrue(user.valid());
    }

    @Test
    void givenInvalidPass_whenValid_thenFalse(){
        User user = new UserImpl("James", "Jameson","jamesjameson","s","9999999999");
        assertFalse(user.valid());
    }

    @Test
    void givenInvalidLogin_whenValid_thenFalse(){
        User user = new UserImpl("James", "Jameson","j","supersecretpass","9999999999");
        assertFalse(user.valid());
    }

    @Test
    void givenInvalidPhoneNumber_whenValid_thenFalse(){
        User user = new UserImpl("James", "Jameson","jamesjameson","supersecretpass","999999999");
        assertFalse(user.valid());
    }

    @Test
    void valid() {
        User user = new UserImpl("James", "Jameson","jamesjameson","supersecretpass","9999999999");
        user.addAccount(null);
        assertEquals(0,user.getBankAccounts().size());
    }
}