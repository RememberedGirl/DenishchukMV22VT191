package bank.service.impl;

import bank.entity.finance.Bank;
import file_gson.CreditAccount;
import file_gson.PaymentAccount;
import bank.entity.man.Employee;
import bank.entity.man.User;
import bank.service.CreditAccountService;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAcc = null;

    /**
     * Создание экземпляра кредитного счёта
     * @param id
     * @param user
     * @param bank
     * @param employee
     * @param paymentAccount
     * @param startDate
     * @param countMonth
     * @param amount
     * @return
     */
    @Override
    public void create(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount,
                       LocalDate startDate, Integer countMonth, Double amount) {
        this.creditAcc = new CreditAccount(id, user, bank, employee, paymentAccount, startDate, countMonth, amount);
        calcMonthlyAmount();
    }

    /**
     * Обновление экземпляра кредитного счёта
     * @param creditAcc
     */
    @Override
    public void update(CreditAccount creditAcc) {
        this.creditAcc = creditAcc;
    }

    /**
     * Обнуление экземпляра кредитного счёта
     */
    @Override
    public void delete() {
        this.creditAcc = null;
    }

    /**
     * Возврат экземпляра кредитного счёта
     * @return
     */
    @Override
    public CreditAccount getCreditAcc() {
        return this.creditAcc;
    }

    /**
     * Расчёт ежемесячной выплаты по кредиту
     */
    private void calcMonthlyAmount() {
        this.creditAcc.setMonthlyAmount((1 + this.creditAcc.getInterestRate() / 100) * this.creditAcc.getAmount()
                / this.creditAcc.getCountMonth());
    }

    /**
     * Одобрение заявки на кредит
     * @param paymentAccount
     * @param employee
     * @return
     */
    @Override
    public Boolean applyLoan(PaymentAccount paymentAccount, Employee employee) {
        if ((this.creditAcc.getAmount() > this.creditAcc.getBank().getMoney()) || (!employee.getCanIssue())
                || (!Objects.equals(this.creditAcc.getEmployee(), employee)))
            return Boolean.FALSE;
        this.creditAcc.getBank().setMoney(this.creditAcc.getBank().getMoney() - this.creditAcc.getAmount());
        paymentAccount.setAmount(paymentAccount.getAmount() + this.creditAcc.getAmount());
        return Boolean.TRUE;
    }
}