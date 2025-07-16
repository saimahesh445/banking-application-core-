import java.util.Scanner;

class BankAccount {
    private double balance;
    private String accountHolder;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
            System.out.println("Updated balance: $" + balance);
        } else {
            System.out.println("Deposit amount should be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            System.out.println("Updated balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance to withdraw.");
        } else {
            System.out.println("Withdrawal amount should be greater than zero.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Fix variable name here

        BankAccount account = new BankAccount("Vyshnavi", 100000.00);
        System.out.println("Welcome " + account.getAccountHolder() + "!");

        boolean continueBanking = true;
        while (continueBanking) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");  // Added prompt text here
            int choice = sc.nextInt(); // Fix variable name here

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble(); // Fix variable name here
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble(); // Fix variable name here
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    continueBanking = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close(); // Fix variable name here
    }
}

