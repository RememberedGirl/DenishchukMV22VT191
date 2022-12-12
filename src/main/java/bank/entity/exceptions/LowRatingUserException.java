package bank.entity.exceptions;

/**
 * Ошибка по низкому рейтингу пользователя
 */
public class LowRatingUserException extends Exception {
    /**
     * Конструктор LowRatingUserException класса ошибок
     * @param bankRating
     * @param userRating
     */
    public LowRatingUserException(Integer bankRating, Integer userRating) {
        super("Кредитный рейтинг пользователя недостаточно высок для выдачи кредита (рейтинг банка - "
                + bankRating + "; кредитный рейтинг пользователя - " + userRating + ")");
    }
}