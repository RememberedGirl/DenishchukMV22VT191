package file_gson;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAccount;
import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Setter
@Getter
/**
 * PaymentAccount - объект платежный счет
 */
public class PaymentAccount extends BankAccount {

    /**
     * Кол-во денег на платежном счету
     * Изначально хотел ставить BigDecimal, но при сложении и вычитании счетов были ошибки
     */
    private Double amount;

    /**
     * Конструктор PaymentAccount
     * @param id
     * @param user
     * @param bank
     */
    public PaymentAccount(Integer id, User user, Bank bank) {
        super(id,user,bank);
        this.amount = 0.0;
    }

    @Override
    public String toString() {
        final String str = "\n1-\t\tИмя банка:\t\t" + super.getBank().getName() +
                "\n2-\t\tФИО пользователя:\t\t" + super.getUser().getFullName();
        return str + String.format("\n3-\t\tСумма денег:\t\t%s₽.\n", new DecimalFormat("#0.00").format(amount));
    }

    public void downloadFromJSON(PaymentAccountJSON jsonPaymentAccount) {
        this.setId(jsonPaymentAccount.getId());
        this.getBank().setId(jsonPaymentAccount.getBankID());
        this.getUser().setId(jsonPaymentAccount.getUserID());
        this.setAmount(jsonPaymentAccount.getAmount());
    }

}