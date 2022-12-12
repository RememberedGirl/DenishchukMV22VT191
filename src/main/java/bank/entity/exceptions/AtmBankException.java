package bank.entity.exceptions;

/**
 * Ошибка по банкомату и банку
 */
public class AtmBankException extends Exception {
    /**
     * Констуктор AtmBankException класса ошибок
     */
    public AtmBankException() {
        super("Банкомат принадлежит другому банку");
    }
}