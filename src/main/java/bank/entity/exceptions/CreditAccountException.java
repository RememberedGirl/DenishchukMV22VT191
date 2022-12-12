package bank.entity.exceptions;

/**
 * Ошибка по кредитному аккаунту
 */
public class CreditAccountException extends Exception{
    /**
     * Конструктор CreditAccountException класса ошибок
     */
    public CreditAccountException() {
        super("Кредитный аккаунт принадлежит другому пользователю");
    }
}
