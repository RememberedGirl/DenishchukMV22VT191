package bank.entity.man;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// User - объект клиент банка, содержит поля:
// id клиента, ФИО, дата рождения, место работы, ежемесячный доход, банки, кредитные счета, платежные счета,
// кредитный рейтинг для банка
@Getter
@Setter
public class User extends Human {
    private String work;
    private Double monthSalary;
    private Integer creditRating;

    public User(Integer id, String name, String surname, LocalDate birthDay, String work) {
        super(id, name, surname, birthDay);
        this.work = work;
        this.monthSalary = null;
        this.creditRating = null;
    }

    public User(Integer id, String name, String surname, String middleName, LocalDate birthDay, String work) {
        super(id, name, surname, middleName, birthDay);
        this.work = work;
        this.monthSalary = null;
        this.creditRating = null;
    }

    @Override
    public String toString() {
        return "ФИО: " + super.getFullName() + "\nДата рождения: " + super.getBirthDay() + "\nРабота: " +
                work + "\nЗарплата: " + monthSalary + "\nКредитный рейтинг: " + creditRating;
    }
}
