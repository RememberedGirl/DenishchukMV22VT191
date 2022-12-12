package bank.entity.exceptions;

/**
 * Ошибка по банкомату и офису
 */
public class AtmOfficeException extends Exception {
    /**
     * Конструктор AtmOfficeException класса ошибок
     */
    public AtmOfficeException() {
        super("Банкомат принадлежит другому банковскому офису");
    }
}
