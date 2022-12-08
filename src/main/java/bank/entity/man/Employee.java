package bank.entity.man;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// Employee - объект сотрудник, содержит поля:
// id сотрудника, ФИО, дата рождения, должность, банк, работает в банке/дистанционно, банквоский офис,
// может ли выдавать кредиты, размер зарплаты
@Setter
@Getter
public class Employee extends Human {
    private Bank bank;
    private BankOffice bankOffice;
    private String jobTitle;
    private Boolean distantWork;
    private Boolean canIssue;
    private Double salary;

    public Employee(Integer id, String name, String surname, LocalDate birthday, Bank bank, BankOffice bankOffice, String jobTitle,
                    Double salary) {
        super(id, name, surname, birthday);
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.jobTitle = jobTitle;
        this.distantWork = true;
        this.canIssue = true;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String str = "ФИО: " + super.getFullName() + "\nДата рождения: " + super.getBirthDay() +
                "\nДолжность: " + jobTitle + "\nИмя банка: " + bank.getName();

        // Проверка на работу в офисе/дистанционно
        if (distantWork)
            str += "\nРаботает в офисе";
        else
            str += "\nРаботает удалённо";

        // Проверка на возможность выдавать кредиты
        if (canIssue)
            str += "\nМожет выдавать кредиты";
        else
            str += "\nНе может выдавать кредиты";

        str += "\nИмя офиса: " + bankOffice.getName() + "\nЗарплата: " + salary;
        return str;
    }
}
