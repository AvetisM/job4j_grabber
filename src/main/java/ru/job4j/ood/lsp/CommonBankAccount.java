package ru.job4j.ood.lsp;

public class CommonBankAccount extends BankAccount {

    public CommonBankAccount(double balance) {
        super(balance);
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(double sum) {
        double newBalance = balance - sum;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Недостаточно средств для выполнения операции");
        } else {
            balance = newBalance;
        }
        return true;
    }
}
