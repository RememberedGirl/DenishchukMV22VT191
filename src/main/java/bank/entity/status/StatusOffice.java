package bank.entity.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * StatusOffice - статус офиса
 */

@RequiredArgsConstructor
@Getter
/**
 * Перечисляемый тип enum StatusOffice
 */
public enum StatusOffice {
    /**
     * Работает
     */
    OPEN("открыт"),

    /**
     * Не работает
     */
    CLOSED("закрыт");

    private final String value;
}

