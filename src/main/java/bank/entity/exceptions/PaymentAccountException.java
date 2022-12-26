package bank.entity.exceptions;

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
