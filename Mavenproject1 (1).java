//Ahmed ALI Muthaffar , Mohammed Fahad Bakheet , Anmar Mahmoud Al-badr

import java.util.Scanner;

public class Mavenproject1 {

   static final int MAX_ACCOUNTS = 5;              // Only 5 accounts allowed

   static String[] accountNames    = new String[MAX_ACCOUNTS];  // Array to store account names
   static double[] accountBalances = new double[MAX_ACCOUNTS];  // Array to store account balances
   static int totalAccounts = 0;                   // Static so it works across all method calls

   static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {

      int choice;

      System.out.println("Welcome to the Basic ATM System!");

      do {                                          // Loop to display the menu repeatedly
         System.out.println("=============================");
         System.out.println("1. Create Account");
         System.out.println("2. Check Balance");
         System.out.println("3. Deposit Money");
         System.out.println("4. Withdraw Money");
         System.out.println("5. Exit");
         System.out.println("=============================");
         System.out.print("Select an option: ");
         choice = input.nextInt();

         switch (choice) {                          // Switch to route to the correct method

            case 1:                                 // Goes to createAccount method
               createAccount();
               break;

            case 2:
               int checkBalance = selectAccount();
               if (checkBalance != -1) {            // Only proceed if the account exists
                  checkBalance(checkBalance);
               }
               break;

            case 3:
               int deposit = selectAccount();
               if (deposit != -1) {
                  deposit(deposit);
               }
               break;

            case 4:
               int withdraw = selectAccount();
               if (withdraw != -1) {
                  withdraw(withdraw);
               }
               break;

            case 5:
               System.out.println("Thank you for using the Basic ATM System!");
               break;

            default:                                // Handles any input outside 1–5
               System.out.println("Invalid option. Please choose 1 - 5.");
         }

      } while (choice != 5);                        // Exit the loop only when user selects 5
   }

   // Method to create a new account
   public static void createAccount() {

      if (totalAccounts >= MAX_ACCOUNTS) {          // Prevent creating more than 5 accounts
         System.out.println("Error: Maximum number of accounts (" +
               MAX_ACCOUNTS + ") reached.");
         return;
      }

      System.out.print("Enter account holder's name: ");
      String name = input.next();

      for (int i = 0; i < totalAccounts; i++) {    // Check for duplicate account names
         if (accountNames[i].equalsIgnoreCase(name)) {
            System.out.println("Error: An account for \"" + name + "\" already exists.");
            return;
         }
      }

      System.out.print("Enter initial deposit amount: ");
      double initialDeposit = input.nextDouble();   // Read the initial deposit amount

      if (initialDeposit < 0) {                    // Reject negative initial deposits
         System.out.println("Error: Initial deposit cannot be negative.");
         return;
      }

      accountNames[totalAccounts]    = name;           // Save the account name
      accountBalances[totalAccounts] = initialDeposit; // Save the initial balance
      totalAccounts++;                                  // Increment account count to stay within limit

      System.out.println("Account created successfully for " + name +
            " with balance: $" + String.format("%.2f", initialDeposit));
   }

   // Method to find and return the index of an account by name
   public static int selectAccount() {

      System.out.print("Enter account holder's name: ");
      String name = input.next();

      for (int i = 0; i < totalAccounts; i++) {
         if (accountNames[i].equalsIgnoreCase(name)) {
            return i;                              // Return the index if a match is found
         }
      }

      System.out.println("Error: Account for \"" + name + "\" not found."); // No matching account
      return -1;
   }

   // Method to check the balance of an account
   public static void checkBalance(int accountIndex) {

      System.out.println("Account holder: " + accountNames[accountIndex]);
      System.out.println("Your balance is: $" + String.format("%.2f", accountBalances[accountIndex]));
   }

   // Method to deposit money into an account
   public static void deposit(int accountIndex) {

      System.out.print("Enter deposit amount: ");
      double amount = input.nextDouble();          // Amount to deposit

      if (amount <= 0) {                          // Reject zero or negative deposit amounts
         System.out.println("Error: Deposit amount must be greater than zero.");
         return;
      }

      accountBalances[accountIndex] += amount;    // Add the deposit to the existing balance

      System.out.println("Deposit successful! New balance: $" +
            String.format("%.2f", accountBalances[accountIndex]));
   }

   // Method to withdraw money from an account
   public static void withdraw(int accountIndex) {

      System.out.print("Enter withdrawal amount: ");
      double amount = input.nextDouble();          // Amount to withdraw

      if (amount <= 0) {                          // Reject zero or negative withdrawal amounts
         System.out.println("Error: Withdrawal amount must be greater than zero.");
         return;
      }

      if (amount > accountBalances[accountIndex]) { // Prevent withdrawing more than available balance
         System.out.println("Error: Insufficient funds.");
         System.out.println("Requested amount : $" + String.format("%.2f", amount));
         System.out.println("Available balance: $" + String.format("%.2f", accountBalances[accountIndex]));
         return;
      }

      accountBalances[accountIndex] -= amount;    // Deduct the withdrawal from the balance

      System.out.println("Withdrawal successful! New balance: $" +
            String.format("%.2f", accountBalances[accountIndex]));
   }

}