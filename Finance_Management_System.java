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


        public void display() {
            if (otp != 0) {  
                double randomValue = Math.random();
                int randomInt = (int)(randomValue * 1000);
                mainBal = randomInt;

                System.out.println("Hello " + name);
                System.out.println("Your account main balance: " + mainBal);
            } else {
                System.out.println("You have entered the wrong OTP. Please enter the correct OTP.");
            }
        }
    }

    public class Finance_Management_System {
        public static void main(String[] args) {
            BankAcctDetails account = new BankAcctDetails();
            account.userInfo();
            account.display();
        }
    }
