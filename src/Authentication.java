import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Authentication {
    private HashMap<String, String> userData;
    private final String FILE_NAME = "accounts.txt";

    public Authentication() {
        userData = new HashMap<>();
        loadAccounts();
    }

    // Load accounts from file
    private void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userData.put(parts[0], parts[1]); // accountNumber -> PIN
                }
            }
        } catch (IOException e) {
            System.out.println("No saved accounts found. Please register.");
        }
    }

    // Save new account to file
    private void saveAccount(String accountNumber, String pin) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(accountNumber + "," + pin);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving account.");
        }
    }

    // Register a new user
    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new account number: ");
        String accountNumber = scanner.nextLine();

        if (userData.containsKey(accountNumber)) {
            System.out.println("Account already exists! Try logging in.");
            return;
        }

        System.out.print("Set a new PIN: ");
        String pin = scanner.nextLine();

        userData.put(accountNumber, pin);
        saveAccount(accountNumber, pin);
        System.out.println("Registration successful! Please log in.");
    }

    // Authenticate user
    public boolean authenticateUser(String accountNumber, String enteredPin) {
        return userData.containsKey(accountNumber) && userData.get(accountNumber).equals(enteredPin);
    }

    // Change PIN
    public void changePin(String accountNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new PIN: ");
        String newPin = scanner.nextLine();

        System.out.print("Confirm new PIN: ");
        String confirmPin = scanner.nextLine();

        if (newPin.equals(confirmPin)) {
            userData.put(accountNumber, newPin);
            saveAllAccounts();
            System.out.println("PIN successfully updated!");
        } else {
            System.out.println("PINs do not match. Try again.");
        }
    }

    // Save all accounts back to file after a PIN change
    private void saveAllAccounts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String acc : userData.keySet()) {
                bw.write(acc + "," + userData.get(acc));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving updated PIN.");
        }
    }
}
