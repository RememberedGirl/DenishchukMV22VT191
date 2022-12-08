package bank.entity.finance;

import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

// PaymentAccount - объект платежный счет, содержит поля:
// id платежного счета, пользователь чей счет, название банка, сумма на счету.
@Setter
@Getter
public class PaymentAccount extends BankAccount {
    private Double amount;

    public PaymentAccount(Integer id, User user, Bank bank) {
        super(id,user,bank);
        this.amount = 0.0;
    }

    @Override
    public String toString() {
        return "Имя банка: " + super.getBank().getName() + "\nФИО пользователя: " + super.getUser().getFullName()
                + "\nСумма денег: " + amount;
    }
}