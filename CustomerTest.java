import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {
        Customer test;
        Deposit test1;
        Deposit test2;
        Withdraw test3;
        Withdraw test4;

        @Before
        public void setUp(){
            test = new Customer("test", 1234, 20, 40);
            test1 = new Deposit(5, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            test2 = new Deposit(5, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            test3 = new Withdraw(5, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            test4 = new Withdraw(5, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);

        }

        @Test
        public void testCheckingDeposit(){
            //Checking if checkBalance hasn't changed
            assertEquals(test.getCheckBalance(), 20.0, 0.0);
            //Use deposit method to add a Deposit
            test.deposit(5, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Converting the deposits ArrayList into strings to test
            String b = test.getDeposits().toString();
            //Check if the deposits contains the right message
            assertTrue(b.contains("Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Checking"));
            //Check if checkBalance is increased by the right amount
            assertEquals(test.getCheckBalance(), 25.0, 5.0);
            //Add another deposit
            test.deposit(3, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Converting the deposits ArrayList into strings to test
            String c = test.getDeposits().toString();
            //Check if it contains the right message for both this and the last deposit
            assertTrue(c.contains("Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Checking"));
            assertTrue(c.contains("Deposit of: $3.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Checking"));
            //Check if checkBalance is increased by the right amount
            assertEquals(test.getCheckBalance(), 28.0, 3.0);
        }

        @Test
        public void testSavingDeposit(){
            //Checking if savingBalance hasn't changed
            assertEquals(test.getSavingBalance(), 40.0, 0.0);
            //Use deposit method to add a Deposit
            test.deposit(5, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Converting the deposits ArrayList into strings to test
            String b = test.getDeposits().toString();
            //Check if the deposits contains the right message
            assertTrue(b.contains("Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Saving"));
            //Check if savingBalance is increased by the right amount
            assertEquals(test.getSavingBalance(), 45.0, 5.0);
            //Add another deposit
            test.deposit(3, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Converting the deposits ArrayList into strings to test
            String c = test.getDeposits().toString();
            //Check if it contains the right message for both this and the last deposit
            assertTrue(c.contains("Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Saving"));
            assertTrue(c.contains("Deposit of: $3.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Saving"));
            //Check if checkBalance is increased by the right amount
            assertEquals(test.getSavingBalance(), 48.0, 3.0);
        }

        @Test
        public void testCheckingWithdrawNoOverdraft(){
            //Checking if checkBalance hasn't changed
            assertEquals(test.getCheckBalance(), 20.0, 0.0);
            //Use withdraw method to add a Withdraw
            test.withdraw(5, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Converting the withdraws ArrayList into strings to test
            String b = test.getWithdraws().toString();
            //Check if the withdraws contains the right message
            assertTrue(b.contains("Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Checking"));
            //Check if checkBalance is decreased by the right amount
            assertEquals(test.getCheckBalance(), 15.0, 5.0);
            //Add another withdraw
            test.withdraw(3, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Converting the withdraws ArrayList into strings to test
            String c = test.getWithdraws().toString();
            //Check if it contains the right message for both this and the last withdraw
            assertTrue(c.contains("Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Checking"));
            assertTrue(c.contains("Withdrawal of: $3.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Checking"));
            //Check if checkBalance is decreased by the right amount
            assertEquals(test.getCheckBalance(), 12.0, 3.0);
        }

        @Test
        public void testSavingWithdrawNoOverdraft(){
            //Checking if savingBalance hasn't changed
            assertEquals(test.getSavingBalance(), 40.0, 0.0);
            //Use withdraw method to add a Withdraw
            test.withdraw(5, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Converting the withdraws ArrayList into strings to test
            String b = test.getWithdraws().toString();
            //Check if the withdraws contains the right message
            assertTrue(b.contains("Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Saving"));
            //Check if savingBalance is decreased by the right amount
            assertEquals(test.getSavingBalance(), 35.0, 5.0);
            //Add another withdraw
            test.withdraw(3, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Converting the withdraws ArrayList into strings to test
            String c = test.getWithdraws().toString();
            //Check if it contains the right message for both this and the last withdraw
            assertTrue(c.contains("Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Saving"));
            assertTrue(c.contains("Withdrawal of: $3.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Saving"));
            //Check if savingBalance is decreased by the right amount
            assertEquals(test.getSavingBalance(), 32.0, 3.0);
        }

        @Test
        public void testCheckingWithdrawHasOverdraft(){
            //Checking if checkBalance hasn't changed
            assertEquals(test.getCheckBalance(), 20.0, 0.0);
            //Use withdraw method to add a Withdraw
            test.withdraw(200, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Checking if checkBalance hasn't changed
            assertEquals(test.getCheckBalance(), 20.0, 0.0);
            //Add another withdraw
            test.withdraw(300, new Date(122, 12, 30, 00, 00, 00), Customer.CHECKING);
            //Checking if checkBalance hasn't changed
            assertEquals(test.getCheckBalance(), 20.0, 0.0);
        }

        @Test
        public void testSavingWithdrawHasOverdraft(){
            //Checking if savingBalance hasn't changed
            assertEquals(test.getSavingBalance(), 40.0, 0.0);
            //Use withdraw method to add a Withdraw
            test.withdraw(200, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Checking if savingBalance hasn't changed
            assertEquals(test.getSavingBalance(), 40.0, 0.0);
            //Add another withdraw
            test.withdraw(300, new Date(122, 12, 30, 00, 00, 00), Customer.SAVING);
            //Checking if savingBalance hasn't changed
            assertEquals(test.getSavingBalance(), 40.0, 0.0);
        }

        @Test
        public void testDepositToString(){
            //Use toString method on Deposit
            String a = test1.toString();
            //Checking if it is equal to the right message
            assertEquals(a, "Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Checking");
            //Use toString method on Deposit
            String b = test2.toString();
            //Checking if it is equal to the right message
            assertEquals(b, "Deposit of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 into account: Saving");
        }

        @Test
        public void testWithdrawToString(){
            //Use toString method on Withdraw
            String a = test3.toString();
            //Checking if it is equal to the right message
            assertEquals(a, "Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Checking");
            //Use toString method on Withdraw
            String b = test4.toString();
            //Checking if it is equal to the right message
            assertEquals(b, "Withdrawal of: $5.0 Date: Mon Jan 30 00:00:00 PST 2023 from account: Saving");
        }
}