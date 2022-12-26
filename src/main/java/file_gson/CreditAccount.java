package file_gson;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAccount;
import bank.entity.man.Employee;
import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
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
        final String str = "\n1-\t\tИмя банка:\t\t" + super.getBank().getName()
                + "\n2-\t\tИмя пользователя:\t\t" + super.getUser().getFullName();
        return str + String.format("\n3-\t\tКоличество месяцев:\t\t%s." +
                        "\n4-\t\tДата взятия кредита:\t\t%s." +
                        "\n5-\t\tПредполагаемая дата погашения кредита:\t\t%s." +
                        "\n6-\t\tСумма кредита:\t\t%s₽." +
                        "\n7-\t\tПроцентная ставка:\t\t%s%%." +
                        "\n8-\t\tЕжемесячный платёж:\t\t%s₽." +
                        "\n9-\t\tСотрудник, выдавший кредит:\t\t%s." +
                        "\n10-\t\tId платёжного счёта:\t\t%s.\n"
                , countMonth, startDate, endDate, new DecimalFormat("#0.00").format(amount),
                        interestRate, new DecimalFormat("#0.00").format(monthlyAmount), employee.getFullName(), paymentAccount.getId());

    }

    public void downloadToJSON(CreditAccountJSON jsonCreditAccount) {
        this.setId(jsonCreditAccount.getId());
        this.getBank().setId(jsonCreditAccount.getBankID());
        this.getUser().setId(jsonCreditAccount.getUserID());
        this.getPaymentAccount().setId(jsonCreditAccount.getPaymentAccountID());
        this.getEmployee().setId(jsonCreditAccount.getEmployeeID());
        this.setStartDate(LocalDate.parse(jsonCreditAccount.getStartDate()));
        this.setEndDate(LocalDate.parse(jsonCreditAccount.getEndDate()));
        this.setCountMonth(jsonCreditAccount.getCountMonth());
        this.setAmount(jsonCreditAccount.getAmount());
        this.setMonthlyAmount(jsonCreditAccount.getMonthlyAmount());
        this.setInterestRate(jsonCreditAccount.getInterestRate());
    }

}
