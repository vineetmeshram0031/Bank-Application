import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name = sc.nextLine();
        String customerId = sc.nextLine();
        BankAccount obj1 = new BankAccount(name, customerId);
        obj1.menu();
    }
}

class BankAccount {
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount > 0) {
            bal += amount;
            prevTrans = amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    void withdraw(double amt) {
        if (amt > 0 && bal >= amt) {
            bal -= amt;
            prevTrans = -amt;
            System.out.println("Withdrawn: " + amt);
        } else if (bal < amt) {
            System.out.println("Bank balance insufficient");
        } else {
            System.out.println("Invalid amount for withdrawal.");
        }
    }

    void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println("\n");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            System.out.println("a) Check Balance");
            System.out.println("b) Deposit Amount");
            System.out.println("c) Withdraw Amount");
            System.out.println("d) Previous Transaction");
            System.out.println("e) Exit");
            System.out.println("********************************************");

            option = sc.next().charAt(0);

            switch (option) {
                case 'a':
                    System.out.println("Balance = " + bal);
                    break;
                case 'b':
                    System.out.println("Enter an amount to deposit:");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    break;
                case 'c':
                    System.out.println("Enter an amount to withdraw:");
                    double amtW = sc.nextDouble();
                    withdraw(amtW);
                    break;
                case 'd':
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    break;
                case 'e':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        } while (option != 'e');

        System.out.println("Thank you for using our banking services");
    }
}