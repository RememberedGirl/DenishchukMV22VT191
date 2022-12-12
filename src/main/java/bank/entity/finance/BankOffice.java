package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import bank.entity.status.StatusOffice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
/**
 * BankOffice - объект офис банка
 */
public class BankOffice {
    /**
     * Id офиса банка
     */
    private int id;

    /**
     * НАзвание офиса банка
     */
    private String name;

    /**
     * Название банка
     */
    private Bank bank;

    /**
     * Адрес офиса банка
     */
    private String address;

    /**
     * Статус офиса банка
     */
    private StatusOffice status;

    /**
     * Возможно ли установить банкомат
     */
    private Boolean maySetATM;

    /**
     * Кол-во банкоматов в офисе
     */
    private int countATM;

    /**
     * Можно ли взять кредит
     */
    private Boolean mayApplyLoan;

    /**
     *  Работает ли выдача денег
     */
    private Boolean mayWithdrawMoney;

    /**
     * Можно ли внести деньги
     */
    private Boolean mayDepositMoney;

    /**
     * Кол-во денег на счету офиса банка
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double money;

    /**
     * Стоимость аренды банковского офиса
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double rentCost;

    /**
     * Массив bankATMS интерфейса List
     */
    private ArrayList<BankAtm> bankATMS;

    /**
     * Массив employees интерфейса List
     */
    private ArrayList<Employee> employees;


    /**
     * Конструктор BankOffice
     * @param id
     * @param name
     * @param bank
     * @param address
     * @param status
     * @param rentCost
     */
    public BankOffice(int id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
        this.id = id;
        this.name = name;
        this.bank = bank;
        this.address = address;
        this.status = status;
        this.maySetATM = true;
        this.countATM = 0;
        this.mayApplyLoan = true;
        this.mayWithdrawMoney = true;
        this.mayDepositMoney = true;
        this.money = 0.0;
        this.rentCost = rentCost;
        this.bankATMS = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    @Override
    public String toString() {
        String str =  String.format("Название офиса: %s. \nИмя банка: %s. \nАдрес: %s. \nСтатус: %s.",
                name, bank.getName(), address, status);

        /**
         * Проверка статуса офиса
         */
        switch (status) {
            case OPEN -> str += StatusOffice.OPEN.getValue();
            case CLOSED -> str += StatusOffice.CLOSED.getValue();
            default -> throw new IllegalArgumentException("Передан несуществующий статус офиса.");
        }

        /**
         * Проверка на возможность добавить банкомат в офис
         */
        if (maySetATM)
            str += "\nМожно добавить банкомат. \nКоличество банкоматов: " + countATM;
        else
            str += "\nНельзя добавить банкомат";


        /**
         * Проверка на возможность выдавать наличные в офисе банка
         */
        str += mayWithdrawMoney ? "\nРаботает на выдачу денег" : "\nНе работает на выдачу денег";

        /**
         * Проверка на возможность выдавать кредиты в офисе банка
         */
        if (mayApplyLoan)
            str += "\nРаботает на выдачу кредитов";
        else
            str += "\nНе работает на выдачу кредитов";

        /**
         * Проверка на возможность вносить наличные деньги в офис банка
         */
        if (mayDepositMoney)
            str += "\nМожно внести деньги";
        else
            str += "\nНельзя внести деньги";
        str += String.format("\nДенежная сумма: %s. \nАрендная плата: %s.", money, rentCost);

        return str;
    }
}
