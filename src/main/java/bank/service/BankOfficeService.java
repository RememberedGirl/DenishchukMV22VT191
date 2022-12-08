package bank.service;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.status.StatusOffice;

public interface BankOfficeService {
    void create(Integer id, String name, Bank bank, String address, StatusOffice status, Double rentCost);
    void update(BankOffice bankOffice);
    void delete();
    BankOffice getBankOffice();

    void addMoney(Double sumMoney);
    Boolean subtractMoney(Double sumMoney);
    Boolean addATM();
    void subtractATM(BankAtm bankATM);
    void SetATMOn();
    void SetATMOff();
    void WithdrawMoneyOn();
    void WithdrawMoneyOff();
    void DepositMoneyOn();
    void DepositMoneyOff();
    void ApplyLoanOn();
    void ApplyLoanOff();
}
