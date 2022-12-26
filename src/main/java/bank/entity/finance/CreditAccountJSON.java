package bank.entity.finance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@AllArgsConstructor
/**
 * CreditAccountJSON - объект JSON кредитного аккаунта
 */
public class CreditAccountJSON {
    /**
     * Id кредитного аккауента JSON
     */
    private Integer id;

    /**
     * Id банка
     */
    private Integer bankID;

    /**
     * Id пользователя
     */
    private Integer userID;

    /**
     * Id платежного аккаунта
     */
    private Integer paymentAccountID;

    /**
     * Id работника
     */
    private Integer employeeID;

    /**
     * Дата начала кредитования
     */
    private String startDate;

    /**
     * Дата окончания кредитования
     */
    private String endDate;

    /**
     * Количество месяцев, на который берется кредит
     */
    private Integer countMonth;

    /**
     * Сумма кредита
     */
    private Double amount;

    /**
     * Ежемесячный платеж
     */
    private Double monthlyAmount;

    /**
     * Рейтинг кредитной ставки
     */
    private Double interestRate;

    /**
     * Конструктор CreditAccountJSON
     * @param creditAccount
     */
    public CreditAccountJSON(@NotNull CreditAccount creditAccount) {
        this.id = creditAccount.getId();
        this.bankID = creditAccount.getBank().getId();
        this.userID = creditAccount.getUser().getId();
        this.paymentAccountID = creditAccount.getPaymentAccount().getId();
        this.employeeID = creditAccount.getEmployee().getId();
        this.startDate = creditAccount.getStartDate().toString();
        this.endDate = creditAccount.getEndDate().toString();
        this.countMonth = creditAccount.getCountMonth();
        this.amount = creditAccount.getAmount();
        this.monthlyAmount = creditAccount.getMonthlyAmount();
        this.interestRate = creditAccount.getInterestRate();
    }
}
