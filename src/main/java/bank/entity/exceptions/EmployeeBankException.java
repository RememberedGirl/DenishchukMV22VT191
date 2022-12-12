package bank.entity.exceptions;

/**
 * Ошибка по принадлежности сотруднику банка
 */
public class EmployeeBankException extends Exception {
    /**
     * Конструктор EmployeeBankException класса ошибок
     */
    public EmployeeBankException() {
        super("Сотрудник принадлежит другому Банку");
    }
}
