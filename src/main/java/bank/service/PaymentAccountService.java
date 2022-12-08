package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.User;

public interface PaymentAccountService {
    void create(Integer id, User user, Bank bank);
    void update(PaymentAccount payAcc);
    void delete();
    PaymentAccount getPayAcc();

    void addMoney(Double sumMoney);
    Boolean subtractMoney(Double sumMoney);
}