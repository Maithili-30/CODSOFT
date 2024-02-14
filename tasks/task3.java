import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            return String.format("Withdrawal successful. Remaining balance: %.2f", userAccount.checkBalance());
        } else {
            return "Withdrawal failed. Insufficient funds.";
        }
    }

    public String deposit(double amount) {
        if (userAccount.deposit(amount)) {
            return String.format("Deposit successful. Updated balance: %.2f", userAccount.checkBalance());
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String checkBalance() {
        return String.format("Current balance: %.2f", userAccount.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    System.out.println(atm.withdraw(amount));
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    System.out.println(atm.deposit(amount));
                    break;
                case 3:
                    System.out.println(atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
