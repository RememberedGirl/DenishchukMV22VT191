package bank.service.impl;

import bank.entity.finance.Bank;
import bank.entity.finance.CreditAccount;
import bank.entity.finance.PaymentAccount;
import bank.entity.man.User;
import bank.service.CreditAccountService;
import bank.service.PaymentAccountService;
import bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 */
public class UserServiceImpl implements UserService {
    private User user = null;

    /**
     * Создание экземпляра пользователя
     * @param id
     * @param name
     * @param surname
     * @param birthDay
     * @param work
     * @return
     */
    @Override
    public void create(Integer id, String name, String surname, LocalDate birthDay, String work) {
        this.user = new User(id, name, surname, birthDay, work);
        calcSalary();
        calcCreditRating();
    }

    /**
     * Обновление экземпляра пользователя
     * @param user
     */
    @Override
    public void update(User user) {
        this.user = user;
    }

    /**
     * Обнуление экземпляра пользователя
     */
    @Override
    public void delete() {
        this.user = null;
    }

    /**
     * Возврат экземпляра пользователя
     * @return
     */
    @Override
    public User getUser() {
        return this.user;
    }

    /**
     * Добавление банка в список банков клиента
     * @param bank
     */
    @Override
    public void addBank(Bank bank) {
        ArrayList<Bank> banks = this.user.getBanks();
        banks.add(bank);
        this.user.setBanks(banks);
    }

    /**
     * Удаление банка из списка банков клиента
     * @param bank
     */
    @Override
    public void delBank(Bank bank) {
        ArrayList<Bank> banks = this.user.getBanks();
        banks.remove(bank);
        this.user.setBanks(banks);
    }

    /**
     * Добавление кредитного счёта в список кредитных счетов клиента
     * @param creditAcc
     * @return
     */
    @Override
    public Boolean addCreditAcc(CreditAccountService creditAcc) {
        if (!Objects.equals(creditAcc.getCreditAcc().getUser(), this.user))
            return false;
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccounts();
        creditAccounts.add(creditAcc.getCreditAcc());
        this.user.setCreditAccounts(creditAccounts);
        creditAcc.getCreditAcc().setUser(this.user);
        return true;
    }

    /**
     * Удаление кредитного счёта из списка кредитных счетов клиента
     * @param creditAcc
     * @return
     */
    @Override
    public Boolean delCreditAcc(CreditAccountService creditAcc) {
        if (!Objects.equals(creditAcc.getCreditAcc().getUser(), this.user))
            return false;
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccounts();
        creditAccounts.remove(creditAcc.getCreditAcc());
        this.user.setCreditAccounts(creditAccounts);
        creditAcc.getCreditAcc().setUser(this.user);
        return true;
    }

    /**
     * Добавление платёжного счёта в список платёжных счетов клиента
     * @param payAcc
     * @return
     */
    @Override
    public Boolean addPayAcc(PaymentAccountService payAcc) {
        if (!Objects.equals(payAcc.getPayAcc().getUser(), this.user))
            return false;
        ArrayList<PaymentAccount> paymentAccounts = this.user.getPaymentAccounts();
        paymentAccounts.add(payAcc.getPayAcc());
        this.user.setPaymentAccounts(paymentAccounts);
        payAcc.getPayAcc().setUser(this.user);
        return true;
    }

    /**
     * Удаление платёжного счёта из списка платёжных счетов клиента
     * @param payAcc
     * @return
     */
    @Override
    public Boolean delPayAcc(PaymentAccountService payAcc) {
        if (!Objects.equals(payAcc.getPayAcc().getUser(), this.user))
            return false;
        ArrayList<PaymentAccount> paymentAccounts = this.user.getPaymentAccounts();
        paymentAccounts.remove(payAcc.getPayAcc());
        this.user.setPaymentAccounts(paymentAccounts);
        payAcc.getPayAcc().setUser(this.user);
        return true;
    }

    /**
     * Получение зарплаты(рандомный способ)
     */
    private void calcSalary() {
        Random random = new Random();
        user.setMonthSalary(random.nextDouble(1, 10000));
    }

    /**
     * Получение кредитного рейтинга пользователя(рандомный способ)
     */
    private void calcCreditRating() {
        int creditRating = 0;
        Integer startRat = 0;
        Integer endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((user.getMonthSalary() <= endRat) && (user.getMonthSalary() >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    /**
     * Смена работы пользователя, заработной платы и пересчёт кредитного рейтинга
     * @param newWork
     * @param newMonthSalary
     */
    @Override
    public void changeWork(String newWork, Double newMonthSalary) {
        user.setWork(newWork);
        user.setMonthSalary(newMonthSalary);
        int creditRating = 0;
        int startRat = 0;
        int endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((newMonthSalary <= endRat) && (newMonthSalary >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    /**
     * Смена заработной платы пользователя и пересчёт кредитного рейтинга
     * @param newMonthSalary
     */
    @Override
    public void changeMonthSalary(Double newMonthSalary) {
        user.setMonthSalary(newMonthSalary);
        int creditRating = 0;
        int startRat = 0;
        int endRat = 1000;
        while ((startRat != 10000) && (creditRating == 0)) {
            if ((newMonthSalary <= endRat) && (newMonthSalary >= startRat))
                creditRating = endRat / 10;
            else {
                startRat += 1000;
                endRat += 1000;
            }
        }
        user.setCreditRating(creditRating);
    }

    /**
     * Вывод полной информации о кредитных и платежных счетах клиента
     * @return
     */
    @Override
    public String getInfo() {
        StringBuilder returnStr = new StringBuilder(this.user.toString());
        returnStr.append("\n\nПлатёжные счета клиента:");
        for (int countPaymentAccount = 0; countPaymentAccount < this.user.getPaymentAccounts().size(); countPaymentAccount++) {
            returnStr.append(String.format("\n\n#%d\n", countPaymentAccount));
            returnStr.append(user.getPaymentAccounts().get(countPaymentAccount).toString());
        }
        returnStr.append("\n\nКредитные счета клиента:");
        for (int countCreditAccount = 0; countCreditAccount < this.user.getCreditAccounts().size(); countCreditAccount++) {
            returnStr.append(String.format("\n\n#%d\n", countCreditAccount));
            returnStr.append(user.getCreditAccounts().get(countCreditAccount).toString());
        }
        return returnStr.toString();
    }
}