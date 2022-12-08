package bank.entity.finance;

import bank.entity.status.StatusOffice;
import lombok.Getter;
import lombok.Setter;

// BankOffice - объект офис банка, содержит поля:
// id банковского офиса, название офиса, адрес офиса, статус, можно ли разместить банкомат, кол-во банкоматов в офисе,
// молжно ли взять кредит, работает ли выдача денег, кол-во денег в банковском офисе, стоимость аренды банковского офиса
@Setter
@Getter
public class BankOffice {
    private Integer id;
    private String name;
    private Bank bank;
    private String address;
    private StatusOffice status;
    private Boolean maySetATM;
    private Integer countATM;
    private Boolean mayApplyLoan;
    private Boolean mayWithdrawMoney;
    private Boolean mayDepositMoney;
    private Double money;
    private Double rentCost;

    public BankOffice(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
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
    }

    @Override
    public String toString() {
        String str =  "Название офиса: " + name + "\nИмя банка: " + bank.getName() + "\nАдрес: " + address +
                "\nСтатус: ";
        // Проверка на статус
        if (status == StatusOffice.OPEN)
            str+= " работает";
        else
            str+= " не работает";

        // Проверка на добавление банкомата
        if (maySetATM)
            str += "\nМожно добавить банкомат. \nКоличество банкоматов: " + countATM;
        else
            str += "\nНельзя добавить банкомат";

        //TODO STRIng cut
        // Проверка на выдачу денег
        str += mayWithdrawMoney ? "\nРаботает на выдачу денег" : "\nНе работает на выдачу денег";

        // Проверка на  выдачу кредитов
        if (mayApplyLoan)
            str += "\nРаботает на выдачу кредитов";
        else
            str += "\nНе работает на выдачу кредитов";

        // Проверка на возможность внести деньги
        if (mayDepositMoney)
            str += "\nМожно внести деньги";
        else
            str += "\nНельзя внести деньги";
        str += "\nДенежная сумма: " + money + "\nАрендная плата: " + rentCost;
        return str;
    }
}
