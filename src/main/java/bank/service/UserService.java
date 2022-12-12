package bank.service;

import bank.entity.exceptions.*;
import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.man.User;

import java.time.LocalDate;

/**
 * Интерфейс User
 * @param
 */
public interface UserService {
    /**
     * Create User
     * @param id
     * @param name
     * @param surname
     * @param birthDay
     * @param work
     * @return
     */
    void create(Integer id, String name, String surname, LocalDate birthDay, String work);

    /**
     * Update User
     * @param user
     */
    void update(User user);

    /**
     * Delete User
     */
    void delete();

    /**
     * Return User
     * @return
     */
    User getUser();

    /**
     * Метод changeWork - позволяет изменить данные о рабочей должности пользователя
     * @param newWork
     * @param newMonthSalary
     */
    void changeWork(String newWork, Double newMonthSalary);

    /**
     * Метод changeMonthSalary - позволяет изменить данные о заработной плате пользователя
     * @param newMonthSalary
     */
    void changeMonthSalary(Double newMonthSalary);


    /**
     * Метод addBank - добавляет банк пользователю
     * @param bank
     */
    void addBank(Bank bank);

    /**
     * Метод delBank - удаляет банк у пользователя
     * @param bank
     */
    void delBank(Bank bank);

    /**
     * Метод addCreditAcc - добавляет кредитный аккаунт пользователю
     * @param creditAcc
     * @return
     */
    void addCreditAcc(CreditAccountService creditAcc) throws CreditAccountException;

    /**
     * Метод delCreditAcc - удаляет кредитный аккаунт у пользователя
     * @param creditAcc
     * @return
     */
    void delCreditAcc(CreditAccountService creditAcc) throws CreditAccountException;

    /**
     * Метод addPayAcc - добавляет платежный аккаунт пользователю
     * @param payAcc
     * @return
     */
    void addPayAcc(PaymentAccountService payAcc) throws PaymentAccountException;

    /**
     * Метод delPayAcc - удаляет платежный аккаунт у пользователя
     * @param payAcc
     * @return
     */
    void delPayAcc(PaymentAccountService payAcc) throws PaymentAccountException;

    void applyForLoan(BankService bank, BankOffice workOffice, Employee workEmployee, BankAtm atm, Double loanSum,
                      LocalDate startDate, Integer countMonth, PaymentAccountService payAcc,
                      CreditAccountService creditAcc) throws CreditException, LowRatingUserException,
            PaymentAccountException, UserBankException, CreditAccountException;

    /**
     * Метод getInfo - выводит данные в понятном и читаемом виде
     * @return
     */
    String toString();
}