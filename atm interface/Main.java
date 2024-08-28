import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return balance;
        }
        balance -= amount;
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void withdraw() {
        while (true) {
            try {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Please try again.");
                    continue;
                }
                double newBalance = account.withdraw(amount);
                System.out.println("Withdrawal successful. New balance: " + newBalance);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }
    }

    public void deposit() {
        while (true) {
            try {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Please try again.");
                    continue;
                }
                double newBalance = account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + newBalance);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }
    }

    public void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your current balance is: " + balance);
    }

    public void run() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}