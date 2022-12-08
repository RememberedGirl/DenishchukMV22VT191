package bank.service.impl;

import bank.entity.finance.Bank;
import bank.service.BankService;

import java.util.Random;

public class BankServiceImpl implements BankService<Bank> {
    private Bank bank = null;

    // Создание экземпляра банка
    @Override
    public Bank create(Integer id, String name) {
        this.bank = new Bank(id, name);
        calcRating();
        calcMoney();
        calcRate();
        return this.bank;
    }

    // Обновление экземпляра банка
    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    // Обнуление экземпляра банка
    @Override
    public void delete() {
        this.bank = null;
    }

    // Возврат экземпляра банка
    @Override
    public Bank getBank() {
        return this.bank;
    }

    // Расчёт рейтинга банка(рандомный способ)
    private void calcRating() {
        Random random = new Random();
        this.bank.setRating(random.nextInt(0, 100));
    }

    // Расчёт суммы денег банка рандомным способом
    private void calcMoney() {
        Random random = new Random();
        this.bank.setMoney(random.nextDouble(0, 1000000));
    }

    // Расчёт процентной ставки банка по рейтингу банка
    private void calcRate() {
        this.bank.setInterestRate(20.0 - this.bank.getRating() / 5.0);
    }

    // Добавление суммы денег в банк
    @Override
    public void addMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoney();
        bank.setMoney(sum + sumMoney);
    }

    // Вычитание суммы денег из банка
    @Override
    public Boolean subtractMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoney();
        if (sumMoney > sum)
            return Boolean.FALSE;
        bank.setMoney(sum - sumMoney);
        return Boolean.TRUE;
    }
}
