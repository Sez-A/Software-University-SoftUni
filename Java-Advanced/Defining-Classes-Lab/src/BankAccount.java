public class BankAccount {
    private int id = 1;
    private double balance;
    private static double interestRate = 0.02;


    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * balance * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}
