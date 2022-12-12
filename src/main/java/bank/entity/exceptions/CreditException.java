package bank.entity.exceptions;

/**
 * Ошибка по кредитованию
 */
public class CreditException extends Exception{
    /**
     * Конструктор CreditException класса ошибок
     * @param message
     */
    public CreditException(String message) {
        super(message);
    }
}
