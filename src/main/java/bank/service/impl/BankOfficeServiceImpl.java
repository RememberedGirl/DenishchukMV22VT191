package bank.service.impl;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.status.StatusOffice;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    private BankOffice bankOffice = null;

    // Создание экземпляра офиса
    @Override
    public void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        this.bankOffice = new BankOffice(id, name, bank, address, status, rentCost);
    }

    // Обновление экземпляра офиса
    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    // Обнуление экземпляра офиса
    @Override
    public void delete() {
        this.bankOffice = null;
    }

    // Возврат экземпляра офиса
    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    // Добавление суммы денег в офис и  в банк офиса
    @Override
    public void addMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        this.bankOffice.getBank().setMoney(sumBank + sumMoney);
        this.bankOffice.setMoney(sumOffice + sumMoney);
    }

    // Вычитание суммы денег из офиса и банка, при условии что  достаточно денег в офисе
    // Если недостаточно false, иначе true
    @Override
    public Boolean subtractMoney(Double sumMoney) {
        Double sumBank = this.bankOffice.getBank().getMoney();
        Double sumOffice = this.bankOffice.getMoney();
        if (sumOffice < sumMoney)
            return Boolean.FALSE;
        this.bankOffice.getBank().setMoney(sumBank - sumMoney);
        this.bankOffice.setMoney(sumOffice - sumMoney);
        return Boolean.TRUE;
    }

    // Добавление нового банкомата в офис и в банк с условием, что можно добавить новый банкомат в офис
    // Если нельзя  false, иначе true
    @Override
    public Boolean addATM() {
        if (!this.bankOffice.getMaySetATM())
            return Boolean.FALSE;
        this.bankOffice.setCountATM(this.bankOffice.getCountATM() + 1);
        this.bankOffice.getBank().setCountATM(this.bankOffice.getBank().getCountATM() + 1);
        return Boolean.TRUE;
    }

    // Удаление(демонтаж) банкомата из офиса и банка
    @Override
    public void subtractATM(BankAtm bankATM) {
        this.bankOffice.setCountATM(this.bankOffice.getCountATM() - 1);
        this.bankOffice.getBank().setCountATM(this.bankOffice.getCountATM() - 1);
        bankATM.setBankOffice(null);
    }

    // Разрешение офису добавлять банкоматы
    @Override
    public void SetATMOn() {
        this.bankOffice.setMaySetATM(Boolean.TRUE);
    }

    // Запрет на добавление банкомата в офис
    @Override
    public void SetATMOff() {
        this.bankOffice.setMaySetATM(Boolean.FALSE);
    }

    // Разрешение офису выдавать деньги
    @Override
    public void WithdrawMoneyOn() {
        this.bankOffice.setMayWithdrawMoney(Boolean.TRUE);
    }

    // Запрет офису выдавать деньги
    @Override
    public void WithdrawMoneyOff() {
        this.bankOffice.setMayWithdrawMoney(Boolean.FALSE);
    }

    // Разрешение офису вносить деньги
    @Override
    public void DepositMoneyOn() {
        this.bankOffice.setMayDepositMoney(Boolean.TRUE);
    }

    // Запрет офису вносить деньги
    @Override
    public void DepositMoneyOff() {
        this.bankOffice.setMayDepositMoney(Boolean.FALSE);
    }


    // Разрешение офису на выдачу кредитов
    @Override
    public void ApplyLoanOn() {
        this.bankOffice.setMayApplyLoan(Boolean.TRUE);
    }

    // Запрет офису на выдачу кредитов
    @Override
    public void ApplyLoanOff() {
        this.bankOffice.setMayApplyLoan(Boolean.FALSE);
    }

}