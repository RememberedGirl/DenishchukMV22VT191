package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    void create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                String profession, Double salary);
    void update(Employee employee);
    void delete();
    Employee getEmployee();

    void DistantWork();
    void OfficeWork();
    void IssueOn();
    void IssueOff();
}