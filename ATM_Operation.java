package ATM.withdraw.com;

import java.util.Scanner;

public class ATM_Operation {
	
	static class bankAccount {
		private double balance;
		
		public bankAccount(double initialBalance) {
			this.balance = initialBalance;
		}
		
		public double getBalance() {
			return balance;
		}
		
		public void deposit(double amount) {
			if (amount > 0) {
				balance += amount;
				System.out.println("Deposit successful. New balance: " + balance);
			} else {
				System.out.println("Invalid deposit amount.");
			}
		}
		
		public void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Invalid withdrawal amount.");
			} else if (amount > balance) {
				System.out.println("Insufficient balance.");
			} else {
				balance -= amount;
				System.out.println("Withdrawal successful. New balance: " + balance);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bankAccount account = new bankAccount(1000.0); // Initial balance of 1000.0
		int choice = 0;
		
		do {
			System.out.println("\n ATM Interface");
			System.out.println(" Check Balance");
			System.out.println(" Deposit money");
			System.out.println(" Withdraw money");
			System.out.println(" Exit");
			System.out.print("Enter your choice: ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a valid number.");
				sc.next();
				System.out.print("Enter your choice: ");
			}
			choice = sc.nextInt();
			switch (choice) {
				case 1 -> System.out.println("Current balance: " + account.getBalance());
				case 2 -> {
					System.out.print("Enter deposit amount: ");
					if (sc.hasNextDouble()) {
						double depositAmount = sc.nextDouble();
						account.deposit(depositAmount);
					} else {
						System.out.println("Invalid input. Please enter a valid number.");
						sc.next();
					}
				}
				case 3 -> {
					System.out.print("Enter withdrawal amount: ");
					if (sc.hasNextDouble()) {
						double withdrawAmount = sc.nextDouble();
						account.withdraw(withdrawAmount);
					} else {
						System.out.println("Invalid input. Please enter a valid number.");
						sc.next();
					}
				}
				case 4 -> System.out.println("Thank you for using the ATM");
				default -> System.out.println("Invalid choice. Select 1 to 4");
			}
		} while (choice != 4);
		
		sc.close();
	}
}
