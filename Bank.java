import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void setAccountDetails() {
        System.out.print("Enter customer name: ");
        customerName = sc.nextLine();
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();
    }

    void displayAccountDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Type of Account: " + accountType);
        System.out.println("Account Balance: " + balance);
    }

    void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Deposited: " + amount + ". Updated balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class Sav_acct extends Account {
    double rate = 0.04; 
    int time = 1; 

    Sav_acct() {
        accountType = "Saving";
    }

    void computeInterest() {
        double interest = balance * Math.pow((1 + rate), time) - balance;
        balance += interest;
        System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
    }

    void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class Cur_acct extends Account {
    double minBalance = 1000;
    double serviceCharge = 100;

    Cur_acct() {
        accountType = "Current";
    }

    void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum! Service charge of " + serviceCharge + " imposed.");
        } else {
            System.out.println("Sufficient balance maintained.");
        }
        System.out.println("Updated balance: " + balance);
    }

    void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sav_acct saving = new Sav_acct();
        Cur_acct current = new Cur_acct();

        
        saving.setAccountDetails();
        current.setAccountDetails();

        int choice;
        do {
            System.out.println("\n======MENU======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest for Savings Account");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the type of account (saving/current): ");
                    String type1 = sc.next();
                    if (type1.equalsIgnoreCase("saving"))
                        saving.deposit();
                    else if (type1.equalsIgnoreCase("current"))
                        current.deposit();
                    else
                        System.out.println("Invalid account type!");
                    break;

                case 2:
                    System.out.print("Enter the type of account (saving/current): ");
                    String type2 = sc.next();
                    if (type2.equalsIgnoreCase("saving"))
                        saving.withdraw();
                    else if (type2.equalsIgnoreCase("current"))
                        current.withdraw();
                    else
                        System.out.println("Invalid account type!");
                    break;

                case 3:
                    saving.computeInterest();
                    break;

                case 4:
                    System.out.print("Enter the type of account (saving/current): ");
                    String type3 = sc.next();
                    if (type3.equalsIgnoreCase("saving"))
                        saving.displayAccountDetails();
                    else if (type3.equalsIgnoreCase("current"))
                        current.displayAccountDetails();
                    else
                        System.out.println("Invalid account type!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
