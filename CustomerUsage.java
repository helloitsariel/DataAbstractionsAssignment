import java.util.Date;

public class CustomerUsage {
    public static void main(String[] args) {
        Customer test = new Customer("test", 1234, 20, 40);

        test.deposit(5, new Date(), Customer.SAVING);
        test.deposit(7, new Date(), Customer.CHECKING);
        test.deposit(10, new Date(), Customer.SAVING);
        test.deposit(4, new Date(), Customer.CHECKING);
        test.deposit(6, new Date(), Customer.SAVING);
        test.deposit(5, new Date(), Customer.CHECKING);

        test.withdraw(7, new Date(), Customer.SAVING);
        test.withdraw(8, new Date(), Customer.CHECKING);
        test.withdraw(4, new Date(), Customer.SAVING);
        test.withdraw(3, new Date(), Customer.CHECKING);
        test.withdraw(200, new Date(), Customer.SAVING);
        test.withdraw(400, new Date(), Customer.CHECKING);

        test.displayDeposits();
        test.displayWithdraws();
        System.out.println(test.getName());
        System.out.println(test.getAccountNumber());
        System.out.println(test.getSavingRate());
        System.out.println(test.getCheckBalance());
        System.out.println(test.getSavingBalance());
    }
}
