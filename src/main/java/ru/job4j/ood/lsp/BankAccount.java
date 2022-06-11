package ru.job4j.ood.lsp;

public class BankAccount {
    public double balance;

    public BankAccount(double balance) {
        checkAccount();
        this.balance = balance;
    }

    public void setBalance(double balance) {
        checkAccount();
        this.balance = balance;
    }

    public void checkAccount() {
        if (balance < 0) {
            throw new IllegalArgumentException("Нельзя создать счет с отрицательным балансом");
        }
    }

    public boolean withdraw(double sum) {
        double newBalance = balance - sum;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Недостаточно средств для выполнения операции");
        } else if (newBalance <= 100) {
            throw new IllegalArgumentException("Остаток на счету должен быть больше 100 руб.");
        } else {
            balance = newBalance;
        }
        return true;
    }
}
