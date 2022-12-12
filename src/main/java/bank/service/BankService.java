package bank.service;

import bank.entity.exceptions.AtmBankException;
import bank.entity.exceptions.EmployeeBankException;
import bank.entity.exceptions.OfficeBankException;
import bank.entity.exceptions.UserBankException;
import bank.entity.finance.Bank;

/**
 * Интерфейс BankService
 * @param
 */
public interface BankService {
    /**
     * Create Bank
     * @param id
     * @param name
     * @return
     */
    void create(Integer id, String name);

    /**
     * Update Bank
     * @param bank
     */
    void update(Bank bank);

    /**
     * Delete Bank
     */
    void delete();

    /**
     * Return Bank
     * @return
     */
    Bank getBank();

    /**
     * Метод addMoney - добавление суммы денег на счет банка
     * @param bank
     * @param sumMoney
     */
    void addMoney(Bank bank, Double sumMoney);

    /**
     * Метод subtractMoney - вычесть сумму денег со счета банка
     * @param bank
     * @param sumMoney
     * @return
     */
    Boolean subtractMoney(Bank bank, Double sumMoney);

    /**
     * Метод addBankOffice - добавляет в банк офис
     * @param bankOffice
     * @return
     */
    void addBankOffice(BankOfficeService bankOffice) throws OfficeBankException;

    /**
     * Метод delBankOffice - удаляет из банка офис
     * @param bankOffice
     * @return
     */
    void delBankOffice(BankOfficeService bankOffice) throws OfficeBankException;

    /**
     * Метод addBankATM - добавляет в банк банкомат
     * @param bankAtm
     * @return
     */
    void addBankATM(AtmService bankAtm) throws AtmBankException;

    /**
     * Метод delBankATM - удаляет из банка банкомат
     * @param bankAtm
     * @return
     */
    void delBankATM(AtmService bankAtm) throws AtmBankException;

    /**
     * Метод addEmployee - добавляет в банк сотрудника
     * @param employee
     * @return
     */
    void addEmployee(EmployeeService employee) throws EmployeeBankException;

    /**
     * Метод delEmployee - удаляет из банка сотрудника
     * @param employee
     * @return
     */
    void delEmployee(EmployeeService employee) throws EmployeeBankException;

    /**
     * Метод addUser - добавляет пользователя банка
     * @param user
     * @return
     */
    void addUser(UserService user) throws UserBankException;

    /**
     * Метод delUser - удаляет пользователя банка
     * @param user
     * @return
     */
    void delUser(UserService user) throws UserBankException;

    /**
     * Метод getInfo - выводит данные в понятном и читаемом виде
     * @return
     */
    String toString();
}