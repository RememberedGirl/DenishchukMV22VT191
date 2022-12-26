package bank.entity.man;

import bank.entity.finance.Bank;
import bank.entity.finance.CreditAccount;
import bank.entity.finance.PaymentAccount;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.SplittableRandom;

@Getter
@Setter
/**
 * User - объект клиент банка
 */
public class User extends Human {
    /**
     * Наименование работы
     */
    private String work;

    /**
     * Ежемесячная зарплата
     */
    private Double monthSalary;

    /**
     * Кредитный рейтинг для банка
     */
    private Integer creditRating;

    /**
     * Массив banks интерфейса List
     */
    private ArrayList<Bank> banks;

    /**
     * Массив creditAccounts интерфейса List
     */
    private ArrayList<CreditAccount> creditAccounts;

    /**
     * Массив paymentAccounts интерфейса List
     */
    private ArrayList<PaymentAccount> paymentAccounts;

    /**
     * Конструктор User (Без отчества)
     * @param id
     * @param name
     * @param surname
     * @param birthDay
     * @param work
     */
    public User(Integer id, String name, String surname, LocalDate birthDay, String work) {
        super(id, name, surname, birthDay);
        this.work = work;
        this.monthSalary = null;
        this.creditRating = 0;
        this.banks = new ArrayList<>();
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
    }

    /**
     * Констурктор User
     * @param id
     * @param name
     * @param surname
     * @param middleName
     * @param birthDay
     * @param work
     */
    public User(Integer id, String name, String surname, String middleName, LocalDate birthDay, String work) {
        super(id, name, surname, middleName, birthDay);
        this.work = work;
        this.monthSalary = null;
        this.creditRating = 0;
        this.banks = new ArrayList<>();
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
    }

    @Override
    public String toString() {
        final String str = "ФИО: " + super.getFullName() + "\nДата рождения: " + super.getBirthDay();
        return str + String.format("\nРабота: %s. \nЗарплата: %s₽. \nКредитный рейтинг: %s.", work,
                new DecimalFormat("#0.00").format(monthSalary), creditRating);
    }
}
