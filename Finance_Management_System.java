import java.util.ArrayList;
import java.util.Scanner;

// Open-Closed Principle A class should be open for extension but closed for modification.
// BankAcctDetails class:
// This is an abstract base class 
// defining the structure of account-related operations 
// like handleTransaction, 
// userInfo, 
// verifyOTP, and 
// display.
// It allows subclasses like ProcessPayment and PickYourField 
// to extend its functionalities without modifying the base class.
// PickYourField and ProcessPayment:

// These subclasses extend BankAcctDetails and implement specific functionalities like selecting a team and handling deposits/withdrawals.
// PaymentHistory:

// This class encapsulates transaction details. It allows us to add transactions (addTransaction) or display them (displayHistory) without modifying other parts of the system.



abstract class BankAcctDetails {
    public int mainBal;
    private int accNum;
    public String name;
    protected int otp;

    public abstract void handleTransaction();

    public void userInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Bank Company Account Number: ");
        accNum = scanner.nextInt();
        System.out.print("Enter your Company Name: ");
        name = scanner.next();
    }

    

    public void verifyOTP() {
        Scanner scanner = new Scanner(System.in);
        boolean otpVerified = false;

        while (!otpVerified) {
            System.out.print("The OTP is sent to the account's registered company number, enter it: ");
            otp = scanner.nextInt();

            if (otp != 0) {
                otpVerified = true;
            } else {
                System.out.println("You have entered the wrong OTP. Please enter the correct OTP.");
            }
        }
    }

    public void display() {
        System.out.println("Hello " + name);
        System.out.println("Your account main balance: " + mainBal);
    }
}

class PaymentHistory {
    private ArrayList<String> history;

    public PaymentHistory() {
        history = new ArrayList<>();
    }

    public void addTransaction(String transactionDetail) {
        history.add(transactionDetail);
    }

    public void displayHistory() {
        System.out.println("Payment History:");
        for (String transaction : history) {
            System.out.println(transaction);
        }
    }
}


class PickYourField extends BankAcctDetails {
    public String teamName;

    public void pickTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please pick your team:");
        System.out.println("1. Marketing");
        System.out.println("2. Sales");
        System.out.println("3. Development");
        System.out.println("4. Human Resources");
        System.out.println("5. Finance");

        System.out.print("Enter the number corresponding to your team: ");
        int choice = scanner.nextInt(); 

        switch (choice) {
            case 1:
                teamName = "Marketing";
                break;
            case 2:
                teamName = "Sales";
                break;
            case 3:
                teamName = "Development";
                break;
            case 4:
                teamName = "Human Resources";
                break;
            case 5:
                teamName = "Finance";
                break;
            default:
                teamName = "Unknown";
                System.out.println("Invalid choice. Please select a valid team.");
                return;
        }

        System.out.println("Welcome" + teamName + " team!");
    }


    public void handleTransaction() {}
}

class ProcessPayment extends BankAcctDetails {
    private double amount;
    public String Reason;
    private PaymentHistory paymentHistory;
    private double depositedAmount;

    public ProcessPayment() {
        paymentHistory = new PaymentHistory();
        depositedAmount = 0;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            deposit();
        } else if (choice == 2) {
            withdraw(scanner);
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your deposit Amount: ");
        amount = scanner.nextDouble();
        mainBal += amount;
        depositedAmount += amount; 

        String transactionDetail = "Deposited: " + amount + " to the account. New balance is: " + mainBal;
        paymentHistory.addTransaction(transactionDetail);
        System.out.println(transactionDetail);

        
        askForPayment(scanner);
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Enter your Withdraw Amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter your Reason for Withdraw Amount: ");
        Reason = scanner.nextLine();
    
        if (amount <= depositedAmount) {
            depositedAmount -= amount; 
            mainBal -= amount; 
            String transactionDetail = "Withdrawn: " + amount + " for reason: " + Reason + ". Remaining from deposit amount: " + depositedAmount;
            paymentHistory.addTransaction(transactionDetail);
            System.out.println(transactionDetail);
        } else {
            System.out.println("You can only withdraw from the deposited amount. Insufficient funds for this withdrawal.");
            askForPayment(scanner); 
        }
    }

    private void askForPayment(Scanner scanner) {
        System.out.print("Do you need to make a payment (withdraw) from the deposited amount? (yes/no): ");
        String response = scanner.next().toLowerCase();

        if (response.equals("yes")) {
            if (depositedAmount == 0) {
                System.out.println("You don't have any deposited funds. Please deposit some money first.");
                deposit(); 
            } else {
                withdraw(scanner);
            }
        } else {
            System.out.println("Deposit complete. No payment needed.");
        }
    }


    public void handleTransaction() {}

    public void endProgram() {
        System.out.println("Transaction complete. The program will now end.");
        paymentHistory.displayHistory(); 
        System.exit(0);
    }
}

class Marketing_Team extends PickYourField {
    public static void display(String teamName, int mainBal) {
        System.out.println("Account remaining amount from " + teamName + " team: " + mainBal);
    }
}

public class Finance_Management_System {
    public static void main(String[] args) {

        PickYourField pick = new PickYourField();
        ProcessPayment account = new ProcessPayment();
        Marketing_Team MTP = new Marketing_Team();

        account.userInfo();
        account.verifyOTP();
        account.display();
        pick.pickTeam();
        account.showMenu();
        MTP.display(pick.teamName, account.mainBal);
    }
}
