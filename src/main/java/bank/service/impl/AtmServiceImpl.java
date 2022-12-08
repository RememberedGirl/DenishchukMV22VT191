package bank.service.impl;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    private BankAtm bankAtm = null;

    // Создание экземпляра банкомата
    @Override
    public void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                       Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee) {
        bank.setCountATM(bank.getCountATM() + 1);
        bankOffice.setCountATM(bankOffice.getCountATM() + 1);
        this.bankAtm = new BankAtm(id, name, status, workPayMoney, workDepositMoney, maintenanceCost, bank,
                bankOffice, employee);
    }

    // Обновление экземпляра банкомата
    @Override
    public void update(BankAtm bankATM) {
        this.bankAtm = bankATM;
    }

    // Обнуление экземпляра банкомата
    @Override
    public void delete() {
        this.bankAtm = null;
    }

    @Override
    public BankAtm getBankAtm() {
        return null;
    }

    // Возврат экземпляра банкомата
    @Override
    public BankAtm getBankATM() {
        return this.bankAtm;
    }


    // При работе банкомата деньги совершают путь: банкомат -> офис банкомата -> банк;
    // Возращается true, иначе false
    @Override
    public Boolean isPossibleToAddMoney(double sumMoney) {
        if (this.bankAtm.getStatus() == StatusATM.OPEN) {
            return Boolean.FALSE;
        }
        this.bankAtm.setMoney(this.bankAtm.getMoney() + sumMoney);
        this.bankAtm.getBankOffice().setMoney(this.bankAtm.getBankOffice().getMoney() + sumMoney);
        this.bankAtm.getBank().setMoney(this.bankAtm.getBank().getMoney() + sumMoney);
        return Boolean.TRUE;
    }

    // При работе банкомата и наличии денег, деньги выдаются путем: банкомат отдает -> офис банкамата отдает ->
    // банк отдает;
    // Возращается true, иначе false
    public Boolean isPossibleToSubstractMoney(double sumMoney) {
        if (this.bankAtm.getStatus() == StatusATM.CLOSED
                || this.bankAtm.getStatus() == StatusATM.OUT_OF_MONEY
                || this.bankAtm.getMoney() < sumMoney)
            return Boolean.FALSE;
        if (this.bankAtm.getMoney() == sumMoney)
            this.bankAtm.setStatus(StatusATM.OUT_OF_MONEY);
        this.bankAtm.setMoney(this.bankAtm.getMoney() - sumMoney);
        this.bankAtm.getBankOffice().setMoney(this.bankAtm.getBankOffice().getMoney() - sumMoney);
        this.bankAtm.getBank().setMoney(this.bankAtm.getBank().getMoney() - sumMoney);
        return Boolean.TRUE;
    }


    // Банкомат может выдавать деньги(разрешено)
    @Override
    public void IssuanceMoneyOn() {
        this.bankAtm.setWorkInsuranceMoney(Boolean.TRUE);
    }

    // Банкомат не может выдавать деньги(запрещено)
    @Override
    public void IssuanceMoneyOff() {
        this.bankAtm.setWorkInsuranceMoney(Boolean.TRUE);
    }

    // Банкомат может получать деньги(разрешено)
    @Override
    public void DepositMoneyOn() {
        this.bankAtm.setWorkDepositMoney(Boolean.TRUE);
    }

    /*Запретить банкому получать деньги*/
    @Override
    public void DepositMoneyOff() {
        this.bankAtm.setWorkDepositMoney(Boolean.TRUE);
    }
}