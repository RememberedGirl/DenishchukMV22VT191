package bank.entity.finance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Bank - объект банк, содержит поля:
 * Id банка, Имя банка, Кол-во офисов, кол-во банкоматов, кол-во сотрудников, кол-во клиентов, рейтинг банка,
 * всего денег в банке, процентная ставка
 */
@Getter
@Setter
@AllArgsConstructor
public class Bank {
    //TODO  wdawda
    private int id;
    private String name;
    private int countOffice;
    private int countATM;
    private int countEmployees;
    private int countClients;
    private int rating;
    private double money;
    private double interestRate;

    // TODO конструктор класса
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
    }

    //TODO toString
    @Override
    public String toString() {
        return String.format("Имя банка: %s. \n Количество офисов: %s. \n", name, countOffice) + 
         "Имя банка: " +  name + "\nКоличество офисов: " + countOffice + "\nКоличество банкоматов: " + countATM +
          "\nКоличество сотрудников: " + countEmployees + "\nКоличество клиентов: " + countClients +
          "\nРейтинг: " + rating + "\nКоличество денег: " + money + "\nПроцентная ставка: " + interestRate;
    }
}
