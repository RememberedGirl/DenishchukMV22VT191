package bank.entity.exceptions;

/**
 * Ошибка по принадлежности работника к офису
 */
public class EmployeeOfficeException extends Exception {

    /**
     * Конструктор EmployeeOfficeException класса ошибок
     */
    public EmployeeOfficeException() {
        super("Работник принадлежит другому банковскому офису");
    }
}
