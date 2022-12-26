package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.man.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
/**
 * Bank - объект банк
 */
public class Bank {
    /**
     * Id банка
     */
    private int id;

    /**
     * Имя банка
     */
    private String name;

    /**
     * Кол-во офисов
     */
    private int countOffice;

    /**
     * Кол-во банкоматов
     */
    private int countATM;

    /**
     * Кол-во сотрудников
     */
    private int countEmployees;

    /**
     * Кол-во клиентов
     */
    private int countClients;

    /**
     * Рейтинг банка
     */
    private int rating;

    /**
     * Кол-во денег в банке
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private double money;

    /**
     * Процентная ставка
     */
    private double interestRate;

    /**
     * Массив offices интерфейса List
     */
    private ArrayList<BankOffice> offices;

    /**
     * Массив atms интерфейса List
     */
    private ArrayList<BankAtm> atms;

    /**
     * Массив employees интерфейса List
     */
    private ArrayList<Employee> employees;

    /**
     * Массив clients интерфейса List
     */
    private ArrayList<User> clients;

    /**
     * Констурктор Bank
     * @param id
     * @param name
     */
    public Bank(int id, final String name) {
        this.id = id;
        this.name = name;
        this.countOffice = 0;
        this.countATM = 0;
        this.countEmployees = 0;
        this.countClients = 0;
        this.rating = 0;
        this.money = 0;
        this.interestRate = 0;
        this.offices = new ArrayList<>();
        this.atms = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Имя банка: %s. \nКоличество офисов: %s. \nКоличество банкоматов: %s. " +
                "\nКоличество сотрудников: %s. \nКоличество клиентов: %s. \nРейтинг: %s. \nКоличество денег: %s₽. " +
                "\nПроцентная ставка: %.2f%%.", name, countOffice, countATM, countEmployees, countClients, rating,
                new DecimalFormat("#0.00").format(money), interestRate);
    }
}
