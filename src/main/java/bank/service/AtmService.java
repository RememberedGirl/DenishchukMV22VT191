package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.status.StatusATM;

public interface AtmService {
    void create(Integer id, String name, StatusATM status, Boolean workPayMoney, Boolean workDepositMoney,
                Double maintenanceCost, Bank bank, BankOffice bankOffice, Employee employee);
    void update(BankAtm bankAtm);
    void delete();
    BankAtm getBankAtm();

    // Возврат экземпляра банкомата
    BankAtm getBankATM();

    Boolean isPossibleToAddMoney(double sumMoney);
    Boolean isPossibleToSubstractMoney(double sumMoney);

    //TODO с маленькой буквы и понятные названия
    void IssuanceMoneyOn();
    void IssuanceMoneyOff();
    void DepositMoneyOn();
    void DepositMoneyOff();
}
