package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.status.StatusATM;

/**
 * Интерфейс AtmService
 * @param
 */
public interface AtmService {

    /**
     * Create BankATM
     * @param id
     * @param name
     * @param status
     * @param workPayMoney
     * @param workDepositMoney
     * @param maintenanceCost
     * @param bank
     * @param bankOffice
     * @param employee
     * @return
     */
    void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee);

    /**
     * Update BankATM
     * @param bankAtm
     */
    void update(BankAtm bankAtm);

    /**
     * Delete BankATM
     */
    void delete();

    /**
     * Return BankAtm
     * @return
     */
    BankAtm getBankAtm();

    /**
     * Return BankAtm
     * @return
     */
     BankAtm getBankATM();

    /**
     * Метод isPossibleToAddMoney - добавление суммы денег к счету
     * @param sumMoney
     * @return
     */
    Boolean isPossibleToAddMoney(double sumMoney);

    /**
     * Метод isPossibleToSubstractMoney - вычесть сумму денег со счета
     * @param sumMoney
     * @return
     */
    Boolean isPossibleToSubstractMoney(double sumMoney);

    Boolean addMoney(Double sumMoney);

    /**
     * Метод IssuanceMoneyOn - выдача денег со счета разрешена/возможна
     */
    void IssuanceMoneyOn();

    /**
     * Метод IssuanceMoneyOn - выдача денег со счета запрещена/невозможна
     */
    void IssuanceMoneyOff();

    /**
     * Метод DepositMoneyOn - внос денег на счет разрешена/возможна
     */
    void DepositMoneyOn();

    /**
     * Метод DepositMoneyOn - внос денег на счет запрещена/невозможна
     */
    void DepositMoneyOff();

}
