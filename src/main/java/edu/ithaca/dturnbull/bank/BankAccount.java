package edu.ithaca.dturnbull.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

    public static boolean isEmailValid(String email){
      //  String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
       if (email.indexOf('@') == -1){
            return false;
        }
        else if(email.length() <= 3){
            return false;
        }
        else if(email.isEmpty()){
                return false;
        }
        else if(email.indexOf('@') == 0 || email.indexOf('.') == 0 ){ //34
            return false;
        }
        else if(!Character.isLetter(email.charAt(email.indexOf('@') - 1))){ //35
            return false;
        }
        else if(email.contains("$") || email.contains("!") || email.contains("#")){ //36
            return false;
        }
        else if(email.charAt(email.indexOf('.')) == email.charAt(email.indexOf('.') + 1)){ // 38
            return false;
        }
        // else if(email.lastIndexOf('.') <= email.length()- 2){
        //     return false;    
        // }
        else if(email.lastIndexOf('.')+ 2 >= email.length()){
            return false;    
        }
        else{
            return true;
        }

    }

    public static void main(String[] args) {
        BankAccount.isEmailValid("abc@gmail.c");
    }
}