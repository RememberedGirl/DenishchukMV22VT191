package bank.service;

import bank.entity.finance.Bank;

public interface BankService<T> {
    T create(Integer id, String name);
    void update(Bank bank);
    void delete();
    T getBank();
    void addMoney(Bank bank, Double sumMoney);
    Boolean subtractMoney(Bank bank, Double sumMoney);
}