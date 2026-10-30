public class bankAccount {
    private double balance;

    public bankAccount(double initialBalance) {
        if(initialBalance<0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than zero.");
        }else {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0 ) {
            System.out.println("Error: Amount must be greater than zero.");
        }else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
        
    }

    
}
