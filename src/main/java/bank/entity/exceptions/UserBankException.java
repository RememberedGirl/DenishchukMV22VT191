package bank.entity.exceptions;

/**
 * Ошибка по принадлежности клиента банку
 */
public class UserBankException extends Exception {
    /**
     * Констуктор UserBankException класса ошибок
     */
    public UserBankException() {
        super("Клиент принадлежит другому банку");
    }
}
