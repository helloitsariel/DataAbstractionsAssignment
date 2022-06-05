import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: Deposit
    //Effects: Returns the Deposit when called as a String in the format of "Deposit of: $" + amount + " Date: "
    // + date + " from account: " + account
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
