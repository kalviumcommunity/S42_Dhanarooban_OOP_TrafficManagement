import java.util.Scanner;

class BankAcctDetails {
    public int mainBal;
    private int accNum;
    public String name;
    protected int otp;

    public void userInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Company Account Number: ");
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

class PickYourField extends BankAcctDetails {
    public String teamName; // Make teamName a class-level variable

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

        System.out.println("Welcome to the " + teamName + " team!");
    }
}

class ProcessPayment extends BankAcctDetails {
    private double amount;
    public String Reason;

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
            withdraw();
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your deposit Amount: ");
        amount = scanner.nextDouble();
        mainBal += amount;
        System.out.println("Deposited: " + amount + ". New balance is: " + mainBal);
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Withdraw Amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter your Reason for Withdraw Amount: ");
        Reason = scanner.nextLine();

        if (amount <= mainBal) {
            mainBal -= amount;
            System.out.println("Withdrawn: " + amount + " for reason: " + Reason);
            System.out.println("New balance is: " + mainBal);
        } else {
            System.out.println("Insufficient funds!");
            deposit();
        }
    }
}

class Marketing_Team extends PickYourField {
    public static void display(String teamName, int mainBal) {
        System.out.println("Account Deposited for the " + teamName + " team: " + mainBal);
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
