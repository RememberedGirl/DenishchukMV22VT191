package bank.entity.exceptions;

/**
 * Ошибка принадлежности банковского счета
 */
public class OfficeBankException extends Exception {
    /**
     * Конструктор OfficeBankException класса ошибок
     */
    public OfficeBankException() {
        super("Банковский офис принадлежит другому банку");
    }
}
