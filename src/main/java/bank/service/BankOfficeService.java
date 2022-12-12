package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.status.StatusOffice;

/**
 * Интерфейс BankOfficeService
 * @param
 */
public interface BankOfficeService {
    /**
     * Create BankOffice
     * @param id
     * @param name
     * @param bank
     * @param address
     * @param status
     * @param rentCost
     * @return
     */
    void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost);

    /**
     * Update BankOffice
     * @param bankOffice
     */
    void update(BankOffice bankOffice);

    /**
     * Delete BankOffice
     */
    void delete();

    /**
     * Return BankOffice
     * @return
     */
    BankOffice getBankOffice();


    /**
     * Метод addMoney - добавление суммы денег к счету офиса
     * @param sumMoney
     */
    void addMoney(Double sumMoney);

    /**
     * Метод subtractMoney - вычесть сумму денег со счета офиса
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Double sumMoney);

    /**
     * Метод addATM - добавляет банкомат в офис
     * @return
     */
    Boolean addATM();

    /**
     * Метод subtractATM - убирает банкомат в офисе
     * @param bankATM
     */
    void subtractATM(BankAtm bankATM);

    /**
     * Метод SetATMOn - установка банкомата разрешена/возможна
     */
    void SetATMOn();

    /**
     * Метод SetATMOff - установка банкомата запрещена/невозможна
     */
    void SetATMOff();

    /**
     * Метод WithdrawMoneyOn - вывод денег со счета офиса запрещен/невозможен
     */
    void WithdrawMoneyOn();

    /**
     * Метод WithdrawMoneyOff - вывод денег со счета офиса разрешен/возможен
     */
    void WithdrawMoneyOff();

    /**
     * Метод DepositMoneyOn - внос денег на счет офиса разрешен/возможен
     */
    void DepositMoneyOn();

    /**
     * Метод DepositMoneyOff - внос денег на счет офиса запрещен/невозможен
     */
    void DepositMoneyOff();

    /**
     * Метод ApplyLoanOn - подача заявки на кредит разрешена/возможна
     */
    void ApplyLoanOn();

    /**
     * Метод ApplyLoanOff - подача заявки на кредит запрещена/невозможна
     */
    void ApplyLoanOff();


    /**
     * Метод addBankATM - добавляет в банк банкомат
     * @param atm
     * @return
     */
    Boolean addBankATM(AtmService atm);

    /**
     * Метод delBankATM - удаляет из банка банкомат
     * @param atm
     * @return
     */
    Boolean delBankATM(AtmService atm);

    /**
     * Метод addEmployee - добавляет работника в банк
     * @param employee
     * @return
     */
    Boolean addEmployee(EmployeeService employee);

    /**
     * Метод delEmployee - удаляет работника из банка
     * @param employee
     * @return
     */
    Boolean delEmployee(EmployeeService employee);
}
