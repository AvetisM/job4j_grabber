package ru.job4j.ood.lsp;

public class SpecialBankAccount extends BankAccount {

    public SpecialBankAccount(double balance) {
        super(balance);
    }

    @Override
    public boolean withdraw(double sum) {
        double newBalance = balance - sum;
        if (newBalance < 0) {
            throw new IllegalArgumentException("Недостаточно средств для выполнения операции");
        } else if (newBalance <= 500) {
            throw new IllegalArgumentException("Остаток на счету должен быть больше 500 руб.");
        } else {
            balance = newBalance;
        }
        return true;
    }
}
