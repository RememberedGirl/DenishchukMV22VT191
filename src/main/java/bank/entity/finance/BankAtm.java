package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

/**
 * BankAtm - объект банкомат
 */
@Setter
@Getter
@AllArgsConstructor
public class BankAtm {
    /**
     * Id банкомата
     */
    private int id;

    /**
     * Имя банкомата
     */
    private String name;

    /**
     * Имя банка
     */
    private Bank bank;

    /**
     * Офис банка
     */
    private BankOffice bankOffice;

    /**
     * Сотрудник, обслуживающий банкомат
     */
    private Employee employee;

    /**
     * Статус банкомата
     */
    private StatusATM status;

    /**
     * Выдает ли деньги банкомат
     */
    private boolean workInsuranceMoney;

    /**
     * Принимает ли деньги банкомат
     */
    private Boolean workDepositMoney;

    /**
     * Кол-во денег в банкомате
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double money;

    /**
     * Стоимость обслуживания банкомата
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double maintenanceCost;


    /**
     * Конструктор BankATM
     * @param id
     * @param name
     * @param status
     * @param workInsuranceMoney
     * @param workDepositMoney
     * @param maintenanceCost
     * @param bank
     * @param bankOffice
     * @param employee
     */
    public BankAtm(int id, final String name, StatusATM status, Boolean workInsuranceMoney, Boolean workDepositMoney,
                   final Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.workInsuranceMoney = workInsuranceMoney;
        this.workDepositMoney = workDepositMoney;
        this.maintenanceCost = maintenanceCost;
        this.bank = bank;
        this.employee = employee;
        this.money = 0.0;
        this.bankOffice = bankOffice;
    }


    @Override
    public String toString() {
        //TODO StringBuilder
        String bankATMInformation = String.format("Имя банкомата: %s. \nАдрес: %s. \nСтатус: %s. ", name, bankOffice.getAddress(), status);
        // Выбор статуса работы банкомата
        switch (status) {
            case OPEN -> bankATMInformation += StatusATM.OPEN.getValue();
            case CLOSED -> bankATMInformation += StatusATM.CLOSED.getValue();
            case OUT_OF_MONEY -> bankATMInformation += StatusATM.OUT_OF_MONEY.getValue();
            default -> throw new IllegalArgumentException("Передан несуществующий статус банкомата.");
        }
        bankATMInformation += String.format("\nИмя банка: %s. \nИмя офиса: %s. \nИмя обслуживающего сотрудника: %s. "
                , bank.getName(), bankOffice.getName(), employee.getFullName());

        /**
         * Проверка на выдачу денег
         */
        if (workInsuranceMoney)
            bankATMInformation += "\nРаботает на выдачу денег";
        else
            bankATMInformation += "\nНе работает на выдачу денег";

        /**
         * Проверка на внос денег
         */
        if (workDepositMoney)
            bankATMInformation += "\nМожно внести деньги";
        else
            bankATMInformation += "\nНельзя внести деньги";

        bankATMInformation += String.format("\nДенежная сумма: %s₽. \nСтоимость обслуживания: %s₽.",
                new DecimalFormat("#0.00").format(money), new DecimalFormat("#0.00").format(maintenanceCost));
        return bankATMInformation;
    }
}
