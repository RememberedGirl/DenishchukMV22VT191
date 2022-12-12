package bank.entity.finance;

import bank.entity.man.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
        final String str = "Имя банка: " + super.getBank().getName() + "\nФИО пользователя: " + super.getUser().getFullName();
        return str + String.format("\nСумма денег: %s. ", amount);
    }
}