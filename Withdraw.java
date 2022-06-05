import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: Withdraw
    //Effects: Returns the Withdraw when called as a String in the format of "Withdrawal of: $" + amount + " Date: "
    // + date + " from account: " + account
    public String toString(){
        //your code here
        return "Withdrawal of: $" + amount + " Date: " + date + " from account: " + account;
    }
}
