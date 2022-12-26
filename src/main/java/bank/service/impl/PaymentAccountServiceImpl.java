package bank.service.impl;

import bank.entity.finance.Bank;
import file_gson.PaymentAccount;
import bank.entity.man.User;
import bank.service.PaymentAccountService;

/**
 *
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount payAcc = null;

    /**
     * Создание экземпляра платёжного счёта
     * @param id
     * @param user
     * @param bank
     * @return
     */
    @Override
    public void create(Integer id, User user, Bank bank) {

        this.payAcc = new PaymentAccount(id, user, bank);
    }

    /**
     * Обновление экземпляра платёжного счёта
     * @param payAcc
     */
    @Override
    public void update(PaymentAccount payAcc) {
        this.payAcc = payAcc;
    }

    /**
     * Обнуление экземпляра платёжного счёта пользователя
     */
    @Override
    public void delete() {
        this.payAcc = null;
    }

    /**
     * Возврат экземпляра платёжного счёта пользователя
     * @return
     */
    @Override
    public PaymentAccount getPayAcc() {
        return this.payAcc;
    }

    /**
     * Добавление суммы денег на платёжный счёт
     * @param sumMoney
     */
    @Override
    public void addMoney(Double sumMoney) {
        this.payAcc.setAmount(this.payAcc.getAmount() + sumMoney);
        this.payAcc.getBank().setMoney(this.payAcc.getBank().getMoney() + sumMoney);
    }

    /**
     * Вычитание суммы денег с платёжного счёта
     * @param sumMoney
     * @return
     */
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        if (this.payAcc.getAmount() < sumMoney)
            return Boolean.FALSE;
        this.payAcc.setAmount(this.payAcc.getAmount() - sumMoney);
        this.payAcc.getBank().setMoney(this.payAcc.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }
}