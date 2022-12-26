package bank.entity.man;

import bank.entity.finance.Bank;
import bank.entity.finance.BankOffice;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDate;

// id сотрудника, ФИО, дата рождения, должность, банк, работает в банке/дистанционно, банквоский офис,
// может ли выдавать кредиты, размер зарплаты
@Setter
@Getter
/**
 * Employee - объект сотрудник
 */
public class Employee extends Human {
    /**
     * Банк, в котором работает содрудник
     */
    private Bank bank;

    /**
     * Офис, в котором работает сотрудник
     */
    private BankOffice bankOffice;

    /**
     * Должность сотрудника банка
     */
    private String jobTitle;

    /**
     * Тип занятости сотрудника - удаленный
     */
    private Boolean distantWork;

    /**
     * Возможность выдавать кредиты сотруднику клиентам банка
     */
    private Boolean canIssue;

    /**
     * Зарплата сотрудника банка
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double salary;

    /**
     * Конструктор Employee
     * @param id
     * @param name
     * @param surname
     * @param birthday
     * @param bank
     * @param bankOffice
     * @param jobTitle
     * @param salary
     */
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
        String str = "ФИО: " + super.getFullName() + "\nДата рождения: " + super.getBirthDay();
        str += String.format("\nДолжность: %s. \nИмя банка: %s.", jobTitle, bank.getName());

        /**
         * Тип занятости сотрудник (дистанционно/очно)
         */
        if (distantWork)
            str += "\nРаботает в офисе.";
        else
            str += "\nРаботает удалённо.";

        /**
         * Выдача кредитов сотрудником (разрешена/запрещена)
         */
        if (canIssue)
            str += "\nМожет выдавать кредиты.";
        else
            str += "\nНе может выдавать кредиты.";

        str += String.format("\nИмя офиса: %s. \nЗарплата: %s₽.", bankOffice.getName(), new DecimalFormat("#0.00").format(salary));
        return str;
    }
}
