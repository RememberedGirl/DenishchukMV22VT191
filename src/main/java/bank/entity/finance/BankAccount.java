package bank.entity.finance;

import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * BankAccount - объект аккант банка
 */
abstract public class BankAccount {
    /**
     * Id аккаунта банка
     */
    private int id;

    /**
     * Пользователь банка
     */
    private User user;

    /**
     * Наименование банка
     */
    private Bank bank;

    /**
     * Конструктор BankAccount
     * @param id
     * @param user
     * @param bank
     */
    public BankAccount(int id, User user, Bank bank){
        this.id = id;
        this.user = user;
        this.bank = bank;
    }
}

