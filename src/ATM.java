import java.util.HashMap;
import java.util.Scanner;

class ATM {
	
	
	
	
	
    private HashMap<String, Customer> user = new HashMap<>();
     Scanner sc=new Scanner(System.in);
	
	public void openAccount(String accountNumber, int pin) {
        Customer newcustomer = new Customer(accountNumber, pin);
        if (user.containsKey(accountNumber)) {
            System.out.println("this account number already exist");

        } else {

            System.out.println("deposite money");

            double money = sc.nextDouble();
            deposit(money);
            System.out.println("Enter mobile number");
            String number = sc.next();
            newcustomer.savemobileNumber(number);
            user.put(accountNumber, newcustomer);
            System.out.print("Account successfully created");
        }
    }

    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}