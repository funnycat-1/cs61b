/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    public int balance;
    Account parentAccount;

    /** Initialize an account with the given BALANCE and set the parentAccount to null. */
    public Account(int balance) {
        this.balance = balance;
        parentAccount = null;
    }
    
    /** Overdraft protecton implemented by adding parentAccount.*/
    public Account(int balance, Account parentAccount){
        parentAccount.balance -= balance;
        this.balance = 0;
    }

    /** Deposits AMOUNT into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract AMOUNT from the account if possible. If subtracting AMOUNT
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        while (balance - amount < 0) {
            if (parentAccount == null){
                System.out.println("Insufficient funds");
                return false;
            }
            else{
                while(parentAccount != null){
                    if (parentAccount.balance + balance - amount > 0){
                        parentAccount.balance -= balance;
                        balance = 0;
                        return true;
                    }
                    else{
                        
                    }
                }
            }            
        } 
    }

    /**
     * Merge account OTHER into this account by removing all money from OTHER
     * and depositing it into this account.
     */
    public void merge(Account other) {
        balance += other.balance;
        other.balance = 0;
    }
    public static void main(String[] args){
        Account kathy = new Account(500);
        Account megan = new Account(100, kathy);
        megan.withdraw(50);
    }
}
