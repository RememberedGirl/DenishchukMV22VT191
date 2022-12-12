package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.User;

/**
 * Интерфейс PaymentAccount
 * @param
 */
public interface PaymentAccountService {

    /**
     * Create PaymentAccount
     * @param id
     * @param user
     * @param bank
     * @return
     */
    void create(Integer id, User user, Bank bank);

    /**
     * Update PaymentAccount
     * @param payAcc
     */
    void update(PaymentAccount payAcc);

    /**
     * Delete PaymentAccount
     */
    void delete();

    /**
     * Return PaymentAccount
     * @return
     */
    PaymentAccount getPayAcc();

    /**
     * Метод addMoney - добавление денег на счет клиента
     * @param sumMoney
     */
    void addMoney(Double sumMoney);

    /**
     * Метод subtractMoney - вычет денег со счета клиента
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Double sumMoney);
}