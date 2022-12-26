package bank.service;

import bank.entity.finance.Bank;
import file_gson.CreditAccount;
import file_gson.PaymentAccount;
import bank.entity.man.Employee;
import bank.entity.man.User;

import java.time.LocalDate;

/**
 * Интерфейс CreditAccountService
 * @param
 */
public interface CreditAccountService {
    /**
     * Create CreditAccount
     * @param id
     * @param user
     * @param bank
     * @param employee
     * @param paymentAccount
     * @param startDate
     * @param countMonth
     * @param amount
     * @return
     */
    void create(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                LocalDate startDate, Integer countMonth, Double amount);

    /**
     * Update CreditAccount
     * @param creditAcc
     */
    void update(CreditAccount creditAcc);

    /**
     * Delete CreditAccount
     */
    void delete();

    /**
     * Return CreditAccount
     * @return
     */
    CreditAccount getCreditAcc();

    /**
     * Метод applyLoan - одобрение заявки на кредитование
     * @param paymentAccount
     * @param employee
     * @return
     */
    Boolean applyLoan(PaymentAccount paymentAccount, Employee employee);
}