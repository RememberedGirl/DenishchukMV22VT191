package bank.entity.finance;

import bank.entity.man.Employee;
import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// CreditAccount - объект кредитный счет, содержит поля:
// id кредитного счета, пользователь, название банка, дата начала кредита, дата окончания кредита,
// кол-во месяцев кредита, сумма кредита, ежемесячный платеж, процентная ставка, сотрудник, платежный счет.
@Setter
@Getter
public class CreditAccount extends BankAccount {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer countMonth;
    private Double amount;
    private Double monthlyAmount;
    private Double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                         LocalDate startDate, Integer countMonth, Double amount) {
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
        return "Имя банка: " + super.getBank().getName() + "\nИмя пользователя: " + super.getUser().getFullName() +
                "\nКоличество месяцев: " + countMonth + "\nДата взятия кредита: " + startDate.toString() +
                "\nПредполагаемая дата погашения кредита:" + endDate.toString() + "\nСумма кредита: " +
                amount + "\nПроцентная ставка: " + interestRate + "%" + "\nЕжемесячный платёж: " +
                countMonth + "\nСотрудник, выдавший кредит: " + employee.getFullName() +
                "\nId платёжного счёта: " + paymentAccount.getId().toString();
    }
}
