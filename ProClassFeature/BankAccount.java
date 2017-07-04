/**
 * Created by lxghost on 2017/7/4.
 */
public class BankAccount {
    private String accountName;
    private String password;
    private double balance;
    private static double interestRate = 0.05;
    private static double minBalance = 15000;
    private static int init = 1001;

    public BankAccount(String password, double balance) {
        this.accountName = String.valueOf(init++);
        this.password = password;
        this.balance = balance;
        if (this.balance < minBalance) {
            System.out.println("Your balance isn't sufficient!");
            this.balance = 0;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        BankAccount.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
