package bank.entity.status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * StatusATM - статус банкомата
 */
@RequiredArgsConstructor
@Getter
/**
 * Перечисляемый тип enum StatusATM
 */
public enum StatusATM {
    /**
     * Работает
     */
    OPEN("открыт"),

    /**
     * Не работает
     */
    CLOSED("закрыт"),

    /**
     * Нет денег
     */
    OUT_OF_MONEY("нет денег");

    private final String value;
}
