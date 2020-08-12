import com.sandeep.beans.Account;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.service.AccountService;
import com.sandeep.service.AccountServiceImpl;

import com.sandeep.utils.EMICalculator;
import com.sandeep.DAO.DatabaseDAOImpl;

// import java.sql.SQLOutput;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws AccountNotFoundException, SQLException {
        boolean flag = true;
        AccountService bankServices = new AccountServiceImpl();
        System.out.println("Kindly chose your option ");
        while (flag) {
            System.out.println("Please chose an option: ");
            System.out.println("1. Create a new account ");
            System.out.println("2. Deposit money in an account");
            System.out.println("3. Withdraw money from an account");
            System.out.println("4. Make Transaction between 2 accounts");
            System.out.println("5. Get Account Details");
            System.out.println("6. Show all accounts");
            System.out.println("7. Show all Transactions");
            System.out.println("8. Calculate EMI");
            System.out.println("9. Exit");
            Scanner sc = new Scanner(System.in);
            int switchKey = sc.nextInt();
            switch (switchKey) {
                case 1:
                    System.out.println("**CREATING NEW ACCOUNT**");
                    System.out.println("Please enter your name");
                    sc.nextLine();
                    String accountHolderName = sc.nextLine();
                    System.out.println("Please enter your account number ");
                    int accountNumber = sc.nextInt();
                    System.out.println("Please enter starting balance");
                    int startingBalance = sc.nextInt();
                    System.out.println("Please enter your pin");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    Account newAccount = new Account(accountHolderName, accountNumber, startingBalance, pin);
                    bankServices.createAccount(newAccount);
                    break;

                case 2:
                    System.out.println("****DEPOSIT MONEY IN ACCOUNT****");
                    System.out.println("Enter your account number");
                    int acc1 = sc.nextInt();
                    System.out.println("Enter the amount you want to deposit");
                    int depAmount = sc.nextInt();
                    bankServices.addAmount(acc1, depAmount, 1);
                    System.out.println("Transaction successful");
                    break;

                case 3:
                    System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
                    System.out.println("Enter your account number");
                    int acc2 = sc.nextInt();
                    System.out.println("Enter the amount you want to Withdraw");
                    int withAmount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo = sc.nextInt();
                    bankServices.getAmount(acc2, pinNo, withAmount, 1);
                    break;

                case 4:
                    System.out.println("****Make Transaction****");
                    System.out.println("Enter your account number");
                    int senderNum = sc.nextInt();
                    System.out.println("Enter Reciever's account number");
                    int recieverNum = sc.nextInt();
                    System.out.println("Enter amount to be transfered");
                    int amount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    pinNo = sc.nextInt();

                    bankServices.makeTransaction(senderNum, recieverNum, amount, pinNo);
                    break;

                case 5:
                    System.out.println("*****ACCOUNT DETAILS********");
                    System.out.println("Enter your account number");
                    int accNo = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo1 = sc.nextInt();
                    List<Object> myAccount = bankServices.loginAccount(accNo, pinNo1);
                    if (myAccount == null) {
                        System.out.println("******Invalid account number or pin******");
                    } else {
                        System.out.println("Welcome to your account : " + myAccount.get(1));
                        System.out.println("Current balance : " + myAccount.get(2));
                    }
                    break;
                case 6:
                    System.out.println("******ALL ACCOUNTS*******");
                    ArrayList<List<Object>> accounts = bankServices.getAllAccounts();
                    for (int i=0; i<accounts.size(); i++) {
                        System.out.println("Account number : " + accounts.get(i).get(0));
                        System.out.println("Account holder name : " + accounts.get(i).get(1));
                        System.out.println("Account balance : " + accounts.get(i).get(2));
                        System.out.println("****************************************************************");
                    }
                    break;

                case 7:
                    System.out.println("******ALL TRANSACTIONS*******");
                    ArrayList<List<Object>> abc = bankServices.getAllTransactions();
                    for (int i=0; i<abc.size(); i++) {
                        System.out.println("Transaction Id : " + abc.get(i).get(0));
                        System.out.println("Transaction Type : " + abc.get(i).get(2));
                        System.out.println("TimeStamp : " + abc.get(i).get(5));
                        System.out.println("Transaction Amount : " + abc.get(i).get(1));
                        System.out.println("Sender Account Number : " + abc.get(i).get(3));
                        System.out.println("Receiver Account Number : " + abc.get(i).get(4));
                        System.out.println("****************************************************************");
                    }
                    break;

                case 8:
                    System.out.println("******CALCULATE EMI*******");
                    System.out.println("Enter total loan amount");
                    int totalAmount = sc.nextInt();
                    System.out.println("Enter number of months");
                    int months = sc.nextInt();
                    int emiAmount = EMICalculator.calculateEMIAmount(totalAmount, months);
                    System.out.println("EMI = :" + emiAmount);
                    break;

                case 9:
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
            // sc.close();
        }

    }

}
