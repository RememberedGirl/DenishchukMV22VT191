package bank.entity.exceptions;

import bank.entity.finance.PaymentAccount;

/**
 * Ошибка принадлежности платежного счета
 */
public class PaymentAccountException extends Exception{
    /**
     * Конструктор PaymentAccountException класса ошибок
     */
    public PaymentAccountException() {
        super("Платёжный счёт принадлежит другому пользователю");
    }
}
