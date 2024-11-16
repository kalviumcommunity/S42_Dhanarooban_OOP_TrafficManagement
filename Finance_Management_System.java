
    import java.util.Scanner;

    class BankAcctDetails {
        public int mainBal; 
        protected int accNum;
        String name;
        int otp;

        public void userInfo() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your Account Number: ");
            accNum = scanner.nextInt();  
            
            System.out.print("Enter your Name: ");
            name = scanner.next();
            
            System.out.print("The OTP is sent to the account's registered mobile number, enter it: ");
            otp = scanner.nextInt(); 
            scanner.close();
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

class ProcessPayment extends BankAcctDetails {
    private double amount;
    public String Reason;

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your deposit Amount: ");
        amount = scanner.nextDouble();
        mainBal += amount; 
        System.out.println("Deposited: " + amount + ". New balance is: " + mainBal);
        // System.out.println("Hello " + accNum);
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
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

class Marketing_Team {
    public static void display(ProcessPayment account) {
        System.out.println("Account Balance from Marketing Team: " + account.mainBal); 
    }
}

public class Finance_Management_System {
    public static void main(String[] args) {
        ProcessPayment account = new ProcessPayment(); 
        Marketing_Team MTP = new Marketing_Team();
        account.userInfo();  
        account.verifyOTP();  
        account.display();  
        account.deposit(); 
        account.withdraw();
        MTP.display(account);
    }
}
