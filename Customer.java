import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        accountNumber = 0;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        checkBalance = 0.0;
        savingBalance = 0.0;
        savingRate = 0.0;
        name = "n/a";
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        savingRate = 0.0;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    //Requires: double, amount of money and String, account type, either CHECKING/SAVING
    //Modifies: this, Deposit
    //Effects: Creates a Deposit using the inputted information and adds it to the ArrayList deposits. If the account
    //is CHECKING, it will add the amount to checkBalance and return checkBalance. If the account is SAVING, it will
    // add the amount to savingBalance and return savingBalance. Else returns -1
    public double deposit(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING)){
            Deposit a = new Deposit(amt, date, account);
            deposits.add(a);
            checkBalance = checkBalance + amt;
            return checkBalance;
        }
        else if (account.equals(SAVING)){
            Deposit a = new Deposit(amt, date, account);
            deposits.add(a);
            savingBalance = savingBalance + amt;
            return savingBalance;
        }
        return -1;
    }

    //Requires: double, amount of money and String account type, either CHECKING/SAVING
    //Modifies: this, Withdraw
    //Effects: If there isn't overdraft, creates a Withdraw using the inputted information and adds it to the ArrayList
    //withdraws. If the account is CHECKING, it will subtract the amount from checkBalance and return checkBalance. If
    // the account is SAVING, it will subtract the amount from savingBalance and return savingBalance. Else returns 0
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING)){
            if(!checkOverdraft(amt, CHECKING)) {
                Withdraw a = new Withdraw(amt, date, account);
                withdraws.add(a);
                checkBalance = checkBalance - amt;
                return checkBalance;
            } else{
                double a = checkBalance - amt;
                return a;
            }
        }
        else if (account.equals(SAVING)){
            if(!checkOverdraft(amt, SAVING)) {
                Withdraw a = new Withdraw(amt, date, account);
                withdraws.add(a);
                savingBalance = savingBalance - amt;
                return savingBalance;
            } else{
                double a = savingBalance - amt;
                return a;
            }
        }
        return 0;
    }

    //Requires: double, amount of money and String account type, either CHECKING/SAVING
    //Modifies: this
    //Effects: Checks if when the amount is subtracted from the checkBalance or savingBalance(depending on the account
    //inputted) is less than OVERDRAFT which is -100, returns true is it is less and returns false it is more
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)){
            if ((checkBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        else if(account.equals(SAVING)){
            if ((savingBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public String getName() {
        return name;
    }
}
