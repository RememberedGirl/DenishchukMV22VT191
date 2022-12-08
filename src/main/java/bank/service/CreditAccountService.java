package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.CreditAccount;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.Employee;
import bank.entity.man.User;

import java.time.LocalDate;

public interface CreditAccountService {
    void create(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                LocalDate startDate, Integer countMonth, Double amount);
    void update(CreditAccount creditAcc);
    void delete();
    CreditAccount getCreditAcc();

    Boolean applyLoan(PaymentAccount paymentAccount, Employee employee);
}