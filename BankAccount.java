import java.util.Scanner;

public class BankAccount {
  private int accountNumber;
  private String accountHolderName;
  private double balance;

  public BankAccount(int accountNumber, String accountHolderName, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = balance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("Deposit successful. New balance: " + balance);
  }

  public void withdraw(double amount) {
    if(amount < 0){
      System.out.println("Invalid amount. Please enter a valid amount.");
    }
    else if (balance < amount) {
      System.out.println("Insufficient balance.");
    } else {
      balance -= amount;
      System.out.println("Withdrawal successful. New balance: " + balance);
    }
  }

  public void checkBalance() {
    System.out.println("Current balance: " + balance);
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter account number: ");
    int accountNumber = scanner.nextInt();

    System.out.print("Enter account holder name: ");
    String accountHolderName = scanner.next();

    System.out.print("Enter initial balance: ");
    double balance = scanner.nextDouble();

    BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);

    while (true) {
      System.out.println("\nSelect an option:");
      System.out.println("1. Deposit money");
      System.out.println("2. Withdraw money");
      System.out.println("3. Check balance");
      System.out.println("4. Exit");

      int option = scanner.nextInt();

      switch (option) {
        case 1:
          try {
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);
          } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
          }
          break;
        case 2:
          try {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);
          } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
          }
          break;
        case 3:
          account.checkBalance();
          break;
        case 4:
          System.exit(0);
        default:
          System.out.println("Invalid option. Please select a valid option.");
      }
    }
  }
}
                    
