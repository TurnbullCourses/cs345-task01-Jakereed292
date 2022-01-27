package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
        assertFalse(BankAccount.isEmailValid("")); // empty string, invalid, cannot be an email as it doesnt have a username & domainname, border case
        assertFalse(BankAccount.isEmailValid("ab@")); // This email address doesnt have domain name so its a border case
        assertFalse(BankAccount.isEmailValid("@gmail.com")); //This email address has no username, so its a border case
        assertTrue(BankAccount.isEmailValid("abc_abc@gmail.com")); // A possible email address, its complete so its not a boder case.
<<<<<<< HEAD
        
        
=======
        assertTrue(BankAccount.isEmailValid("abc@gmail.com"));
        assertTrue(BankAccount.isEmailValid("abc.abc@gmail.com"));
        assertFalse(BankAccount.isEmailValid(".abc@gmail.com"));
        assertFalse(BankAccount.isEmailValid("abc-@gmail.com"));
        assertFalse(BankAccount.isEmailValid("abc$abc@gmail.com"));
        assertFalse(BankAccount.isEmailValid("abc@gmail$com"));
        assertFalse(BankAccount.isEmailValid("abc@gmail..com"));
        assertTrue(BankAccount.isEmailValid("abc@gmail.cc"));
        assertFalse(BankAccount.isEmailValid("abc@gmail.c"));
        assertTrue(BankAccount.isEmailValid("abc@mail-room.com"));
>>>>>>> 8e86d4e6d806dbf351982174b37ce126c5ce5c09
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}

//comments for Equivalence partition
// 1) a@b.com -> valid
//    a_a@b.com -> valid
//    @@b.com -> invalid
//    .@b.com -> invalid
//   12@b.com -> valid

// 2) "" -> invalid
//    a@b.com -> valid
// a@b.edu -> valid

// 3) "ab@" -> invalid
//  ab@a -> invalid
// (0-9)@ ->invalid
// ab@ab -> invalid
// @@ ->invalid
// ab@$ -> invalid
// ab@a.com -> valid

// 4) "@gmail.com" -> invalid
//     a@gmail.com -> valid
//   @@gmail.com ->invalid
// @gmail.edu ->invalid
// @yahoo.com  ->invalid
// ab@gmail.com ->valid

// 5) abc_abc@gmail.com -> valid
//    abc@gmail.com -> valid
// $$$@gmail.com -> invalid
// ab12@gmail.com -> valid
// 012_abc@gmail.com -> valid
// @_abc@gmail.com -> invalid