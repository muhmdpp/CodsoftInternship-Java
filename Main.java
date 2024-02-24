import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: Rs." + userAccount.checkBalance());
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: Rs." + userAccount.checkBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs." + userAccount.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs.");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
