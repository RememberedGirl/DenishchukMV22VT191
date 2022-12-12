package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
/**
 * CreditAccount - объект кредитный счет
 */
public class CreditAccount extends BankAccount {
    /**
     * Дата начала кредитования
     */
    private LocalDate startDate;

    /**
     * Дата окончания кредитования
     */
    private LocalDate endDate;

    /**
     * Кол-во месяцев кредитования
     */
    private int countMonth;

    /**
     * Сумма взятого кредита
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double amount;

    /**
     * Ежемесячный платеж
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double monthlyAmount;

    /**
     * Процентная ставка
     */
    private Double interestRate;

    /**
     * Сотрудник, ведущий кредитование
     */
    private Employee employee;

    /**
     * Аккаунт плательщика
     */
    private PaymentAccount paymentAccount;

    /**
     * Конструктор CreditAccount
     * @param id
     * @param user
     * @param bank
     * @param employee
     * @param paymentAccount
     * @param startDate
     * @param countMonth
     * @param amount
     */
    public CreditAccount(int id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                         LocalDate startDate, int countMonth, Double amount) {
        super(id, user, bank);
        this.startDate = startDate;
        this.countMonth = countMonth;
        this.endDate = startDate.plusMonths(this.countMonth);
        this.amount = amount;
        this.interestRate = bank.getInterestRate();
        this.monthlyAmount = null;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        final String str = "Имя банка: " + super.getBank().getName() + "\nИмя пользователя: " + super.getUser().getFullName();
        return str + String.format("\nКоличество месяцев: %s. \nДата взятия кредита: %s. \nПредполагаемая дата погашения кредита: %s." +
                        "\nСумма кредита: %s. \nПроцентная ставка: %s. \nЕжемесячный платёж: %s. \nСотрудник, выдавший кредит: %s." +
                                "\nId платёжного счёта: %s.", countMonth, startDate, endDate, amount,
                        interestRate, monthlyAmount, employee.getFullName(), paymentAccount.getId());

    }
}
