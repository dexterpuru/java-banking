import com.sandeep.beans.Account;
import com.sandeep.beans.Transaction;
import com.sandeep.exceptions.AccountNotFoundException;
import com.sandeep.service.AccountService;
import com.sandeep.service.AccountServiceImpl;

import com.sandeep.utils.EMICalculator;

// import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws AccountNotFoundException {
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
                    int newAmount = bankServices.addAmount(acc1, depAmount).getCurrentBalance();
                    System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
                    break;

                case 3:
                    System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
                    System.out.println("Enter your account number");
                    int acc2 = sc.nextInt();
                    System.out.println("Enter the amount you want to Withdraw");
                    int withAmount = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo = sc.nextInt();
                    Account account = bankServices.getAmount(acc2, pinNo, withAmount);

                    if (account == null) {
                        System.out.println("Invalid operation");
                    } else {
                        int newAmount1 = account.getCurrentBalance();
                        System.out.println("Transaction successful \nUpdated Balance:" + newAmount1);
                    }
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

                    Account accountSender = bankServices.makeTransaction(senderNum, recieverNum, amount, pinNo);
                    if (accountSender == null) {
                        System.out.println("Invalid Operation");
                    } else {
                        System.out.println(
                                "Transaction is completed \nUpdated balance" + accountSender.getCurrentBalance());
                    }
                    break;

                case 5:
                    System.out.println("*****ACCOUNT DETAILS********");
                    System.out.println("Enter your account number");
                    int accNo = sc.nextInt();
                    System.out.println("Enter your pin number");
                    int pinNo1 = sc.nextInt();
                    Account myAccount = bankServices.loginAccount(accNo, pinNo1);
                    if (myAccount == null) {
                        System.out.println("******Invalid account number or pin******");
                    } else {
                        System.out.println("Welcome to your account : " + myAccount.getAccountHolderName());
                        System.out.println("Current balance : " + myAccount.getCurrentBalance());
                    }
                    break;
                case 6:
                    System.out.println("******ALL ACCOUNTS*******");
                    for (Map.Entry<Integer, Account> accountEntry : bankServices.getAllAccounts().entrySet()) {
                        System.out.println("Account number : " + accountEntry.getValue().getAccountNumber());
                        System.out.println("Account holder name : " + accountEntry.getValue().getAccountHolderName());
                        System.out.println("Account balance : " + accountEntry.getValue().getCurrentBalance());
                        System.out.println("****************************************************************");
                    }
                    break;

                case 7:
                    System.out.println("******ALL TRANSACTIONS*******");
                    HashMap<UUID, Transaction> abc = bankServices.getAllTransactions();
                    Set<Map.Entry<UUID, Transaction>> bcd = abc.entrySet();
                    for (Map.Entry<UUID, Transaction> transactionRecord : bcd) {
                        System.out.println("Transaction Id : " + transactionRecord.getValue().getTxId());
                        System.out.println("Transaction Type : " + transactionRecord.getValue().getTxType());
                        System.out.println("TimeStamp : " + transactionRecord.getValue().getTxTimestamp());
                        System.out.println("Transaction Amount : " + transactionRecord.getValue().getAmount());
                        System.out.println("Sender Account Number : " + transactionRecord.getValue().getSender());
                        System.out.println("Reciever Account Number : " + transactionRecord.getValue().getReciever());
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
