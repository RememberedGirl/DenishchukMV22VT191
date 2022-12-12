package bank.service;

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
    Boolean addBankOffice(BankOfficeService bankOffice);

    /**
     * Метод delBankOffice - удаляет из банка офис
     * @param bankOffice
     * @return
     */
    Boolean delBankOffice(BankOfficeService bankOffice);

    /**
     * Метод addBankATM - добавляет в банк банкомат
     * @param bankAtm
     * @return
     */
    Boolean addBankATM(AtmService bankAtm);

    /**
     * Метод delBankATM - удаляет из банка банкомат
     * @param bankAtm
     * @return
     */
    Boolean delBankATM(AtmService bankAtm);

    /**
     * Метод addEmployee - добавляет в банк сотрудника
     * @param employee
     * @return
     */
    Boolean addEmployee(EmployeeService employee);

    /**
     * Метод delEmployee - удаляет из банка сотрудника
     * @param employee
     * @return
     */
    Boolean delEmployee(EmployeeService employee);

    /**
     * Метод addUser - добавляет пользователя банка
     * @param user
     * @return
     */
    Boolean addUser(UserService user);

    /**
     * Метод delUser - удаляет пользователя банка
     * @param user
     * @return
     */
    Boolean delUser(UserService user);

    /**
     * Метод getInfo - выводит данные в понятном и читаемом виде
     * @return
     */
    String getInfo();
}