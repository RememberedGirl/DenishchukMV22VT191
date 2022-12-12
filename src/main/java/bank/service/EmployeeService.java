package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;

import java.time.LocalDate;

/**
 * Интерфейс Employee
 * @param
 */
public interface EmployeeService {
    /**
     * Create Employee
     * @param id
     * @param name
     * @param surname
     * @param birthday
     * @param bank
     * @param bankOffice
     * @param profession
     * @param salary
     * @return
     */
    void create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                String profession, Double salary);

    /**
     * Update Employee
     * @param employee
     */
    void update(Employee employee);

    /**
     * Delete Employee
     */
    void delete();

    /**
     * Return Employee
     * @return
     */
    Employee getEmployee();

    /**
     * Метод DistantWork - сотрудник работает удаленно/дистанционно
     */
    void DistantWork();

    /**
     * Метод DistantWork - сотрудник работает очно/офис
     */
    void OfficeWork();

    /**
     * Метод IssueOn - сотрудник может выдавать кредиты
     */
    void IssueOn();

    /**
     * Метод IssueOff - сотрудник не может выдавать кредиты
     */
    void IssueOff();
}