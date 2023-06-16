public class Account {
    private static int account_count = 0;
    private double balance;
    private int id;

    public Account() {
        this.id = account_count++;
    }

    public Account(double startingBalance) {
        this.balance = startingBalance;
        this.id = account_count++;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}
