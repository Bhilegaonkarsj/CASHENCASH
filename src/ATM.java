import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        BankAccount account = new BankAccount(1000); // Initial balance

        System.out.println("Welcome to the ATM!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String accountNumber;
        String pin;

        if (option == 1) {
            auth.registerUser();
            return; // Exit after registration
        }

        // Login Process
        System.out.print("Enter your account number: ");
        accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        pin = scanner.nextLine();

        if (!auth.authenticateUser(accountNumber, pin)) {
            System.out.println("Authentication failed! Exiting...");
            return;
        }

        // Menu loop
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    auth.changePin(accountNumber);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
