
import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.0); // Initial balance set to $1000

        while (true) {
        	
        	System.out.println("Is your account available????");
        	String answer=scanner.nextLine();
        	
        	if(answer.equals("Yes")) {
        		System.out.println("Checkout Process::::");
        	}
        	
        	if(answer.equals("Yes")) {
            System.out.println("\nATM Menu:");
            
            
            
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        	}
        	
        }
    }
}
