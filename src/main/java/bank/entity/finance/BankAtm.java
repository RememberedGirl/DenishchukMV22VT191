package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BankAtm - объект банкомат, содержит поля:
// id банкомата, имя банкомата, адрес, статус, банк, расположение банкомата, обслуживает сотрудник,
// работает ли на выдачу денег, можно ли внести деньги, кол-во денег в банкомате, стоимость обслуживания.
@Setter
@Getter
@AllArgsConstructor
public class BankAtm {
    private Integer id;
    private String name;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private StatusATM status;
    private Boolean workInsuranceMoney;
    private Boolean workDepositMoney;
    private Double money;
    private Double maintenanceCost;

    //TODO Большая буква = final
    public BankAtm(Integer id, final String name, StatusATM status, Boolean workInsuranceMoney, Boolean workDepositMoney,
                   Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
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
        String bankATMInformation = "Имя банкомата: " + name + "\nАдрес: " + bankOffice.getAddress() + "\nСтатус: ";
        // Выбор статуса работы банкомата
        switch (status) {
            case OPEN -> bankATMInformation += StatusATM.OPEN.getValue();
            case CLOSED -> bankATMInformation += StatusATM.CLOSED.getValue();
            case OUT_OF_MONEY -> bankATMInformation += StatusATM.OUT_OF_MONEY.getValue();
            default -> throw new IllegalArgumentException("Передан несуществующий статус банкомата");
        }
        bankATMInformation += "\nИмя банка: " + bank.getName() + "\nИмя офиса: " + bankOffice.getName() +
                "\nИмя обслуживающего сотрудника: " + employee.getFullName();

        // Проверка на выдачу денег
        if (workInsuranceMoney)
            bankATMInformation += "\nРаботает на выдачу денег";
        else
            bankATMInformation += "\nНе работает на выдачу денег";

        // Проверка на внос денег
        if (workDepositMoney)
            bankATMInformation += "\nМожно внести деньги";
        else
            bankATMInformation += "\nНельзя внести деньги";

        bankATMInformation += "\nДенежная сумма: " + money + "\nСтоимость обслуживания: " + maintenanceCost;
        return bankATMInformation;
    }
}
