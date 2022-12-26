package bank.entity.finance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Getter
@Setter
@AllArgsConstructor
/**
 * PaymentAccountJSON - объект JSON платежного аккаунта
 */
public class PaymentAccountJSON {
    /**
     * Id платежного аккаунта
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
     * Денежная сумма
     */
    private Double amount;

    /**
     * Конструктор PaymentAccountJSON
     * @param paymentAccount
     */
    public PaymentAccountJSON(@NotNull PaymentAccount paymentAccount) {
        this.id = paymentAccount.getId();
        this.bankID = paymentAccount.getBank().getId();
        this.userID = paymentAccount.getUser().getId();
        this.amount = paymentAccount.getAmount();
    }
}
