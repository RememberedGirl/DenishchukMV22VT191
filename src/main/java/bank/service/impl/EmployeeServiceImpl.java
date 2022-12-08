package bank.service.impl;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee = null;

    // Создание экземпляра сотрудника
    @Override
    public void create(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice,
                       String profession, Double salary) {
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        this.employee = new Employee(id, name, surname, birthday, bank, bankOffice, profession, salary);
    }

    // Обновление экземпляра сотрудника
    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    // Обнуление экземпляра сотрудника
    @Override
    public void delete() {
        this.employee = null;
    }

    // Возврат экземпляра сотрудника
    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    // Перевод работника на дистанционную работу
    @Override
    public void DistantWork() {
        this.employee.setDistantWork(Boolean.TRUE);
    }

    // Перевод работника на работу в офисе
    @Override
    public void OfficeWork() {
        this.employee.setDistantWork(Boolean.FALSE);
    }

    // Разрешение работнику на право выдачу кредитов
    @Override
    public void IssueOn() {
        this.employee.setCanIssue(Boolean.TRUE);
    }

    // Запрет работнику на право выдачи кредитов
    @Override
    public void IssueOff() {
        this.employee.setCanIssue(Boolean.FALSE);
    }
}
