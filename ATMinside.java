import java.util.Scanner;

// Step 1: Create a class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Step 3: Implement methods for each option
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            account.debit(amount);
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        } else {
            account.credit(amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }
}

// Step 4: Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMinside {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 4: Initialize user's account
        BankAccount userAccount = new BankAccount(1000.0); // starting with $1000
        ATM atm = new ATM(userAccount); // Step 5: Connect ATM to user's account

        boolean running = true;

        while (running) {
            // Step 2: Design user interface
            System.out.println("\n--- ATM Interface ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();

            // Step 6 & 7: Validate and display appropriate messages
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
/*
--- ATM Interface ---
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option (1-4): 1
Enter amount to withdraw: 500
Withdrawal successful. New balance: $500.0

--- ATM Interface ---
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option (1-4): 3
Current balance: $500.0

--- ATM Interface ---
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option (1-4): 2
Enter amount to deposit: 200
Deposit successful. New balance: $700.0

--- ATM Interface ---
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option (1-4): 1
Enter amount to withdraw: 800
Insufficient balance for withdrawal.

--- ATM Interface ---
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option (1-4): 4
Thank you for using the ATM. Goodbye!
*/