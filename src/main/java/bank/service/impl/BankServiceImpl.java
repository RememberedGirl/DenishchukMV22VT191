package bank.service.impl;

import bank.entity.finance.Bank;
import bank.entity.finance.BankAtm;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.man.User;
import bank.service.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 */
public class BankServiceImpl implements BankService {
    private Bank bank = null;

    /**
     * Создание экземпляра банка
     * @param id
     * @param name
     * @return
     */
    @Override
    public void create(Integer id, String name) {
        this.bank = new Bank(id, name);
        calcRating();
        calcMoney();
        calcRate();
    }

    /**
     * Обновление экземпляра банка
     * @param bank
     */
    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    /**
     * Обнуление экземпляра банка
     */
    @Override
    public void delete() {
        this.bank = null;
    }

    /**
     * Возврат экземпляра банка
     * @return
     */
    @Override
    public Bank getBank() {
        return this.bank;
    }

    /**
     * Добавление офиса в список офисов банка
     * @param bankOffice
     * @return
     */
    @Override
    public Boolean addBankOffice(BankOfficeService bankOffice) {
        if (!Objects.equals(bankOffice.getBankOffice().getBank(), this.bank))
            return false;
        ArrayList<BankOffice> offices = this.bank.getOffices();
        offices.add(bankOffice.getBankOffice());
        this.bank.setOffices(offices);
        bankOffice.getBankOffice().setBank(this.bank);
        return true;
    }

    /**
     * Удаление офиса из списка офисов банка
     * @param bankOffice
     * @return
     */
    @Override
    public Boolean delBankOffice(BankOfficeService bankOffice) {
        if (!Objects.equals(bankOffice.getBankOffice().getBank(), this.bank))
            return false;
        ArrayList<BankOffice> offices = this.bank.getOffices();
        offices.remove(bankOffice.getBankOffice());
        this.bank.setOffices(offices);
        bankOffice.getBankOffice().setBank(this.bank);
        return true;
    }

    /**
     * Добавление банкомата в список банкоматов банка
     * @param bankATM
     * @return
     */
    @Override
    public Boolean addBankATM(AtmService bankATM) {
        if (!Objects.equals(bankATM.getBankATM().getBank(), this.bank))
            return false;
        ArrayList<BankAtm> atms = this.bank.getAtms();
        atms.add(bankATM.getBankATM());
        this.bank.setAtms(atms);
        bankATM.getBankATM().setBank(this.bank);
        return true;
    }

    /**
     * Удаление банкомата из списка банкоматов банка
     * @param bankATM
     * @return
     */
    @Override
    public Boolean delBankATM(AtmService bankATM) {
        if (!Objects.equals(bankATM.getBankATM().getBank(), this.bank))
            return false;
        ArrayList<BankAtm> atms = this.bank.getAtms();
        atms.remove(bankATM.getBankATM());
        this.bank.setAtms(atms);
        bankATM.getBankATM().setBank(this.bank);
        return true;
    }

    /**
     * Добавление работника в список работников банка
     * @param employee
     * @return
     */
    @Override
    public Boolean addEmployee(EmployeeService employee) {
        if (!Objects.equals(employee.getEmployee().getBank(), this.bank))
            return false;
        ArrayList<Employee> bankEmployees = this.bank.getEmployees();
        bankEmployees.add(employee.getEmployee());
        this.bank.setEmployees(bankEmployees);
        employee.getEmployee().setBank(this.bank);
        return true;
    }

    /**
     * Удаление работника из списка работников банка
     * @param employee
     * @return
     */
    @Override
    public Boolean delEmployee(EmployeeService employee) {
        if (!Objects.equals(employee.getEmployee().getBank(), this.bank))
            return false;
        ArrayList<Employee> bankEmployees = this.bank.getEmployees();
        bankEmployees.remove(employee.getEmployee());
        this.bank.setEmployees(bankEmployees);
        employee.getEmployee().setBank(this.bank);
        return true;
    }

    /**
     * Добавление клиента в список клиентов банка
     * @param user
     * @return
     */
    @Override
    public Boolean addUser(UserService user) {
        if (this.bank.getClients().contains(user.getUser()))
            return false;
        ArrayList<User> clients = this.bank.getClients();
        clients.add(user.getUser());
        this.bank.setCountClients(this.bank.getCountClients() + 1);
        this.bank.setClients(clients);
        user.addBank(this.bank);
        return true;
    }

    /**
     * Удаление клиента из списка клиентов банка
     * @param user
     * @return
     */
    @Override
    public Boolean delUser(UserService user) {
        if (!this.bank.getClients().contains(user.getUser()))
            return false;
        ArrayList<User> clients = this.bank.getClients();
        clients.remove(user.getUser());
        this.bank.setCountClients(this.bank.getCountClients() + 1);
        this.bank.setClients(clients);
        user.delBank(this.bank);
        return true;
    }


    /**
     * Расчёт рейтинга банка(рандомный способ)
     */
    private void calcRating() {
        Random random = new Random();
        this.bank.setRating(random.nextInt(0, 100));
    }

    /**
     * Расчёт суммы денег банка (рандомный способ)
     */
    private void calcMoney() {
        Random random = new Random();
        this.bank.setMoney(random.nextDouble(0, 1000000));
    }

    /**
     * Расчёт процентной ставки банка по рейтингу банка
     */
    private void calcRate() {
        this.bank.setInterestRate(20.0 - this.bank.getRating() / 5.0);
    }

    /**
     * Добавление суммы денег на счет банка
     * @param bank
     * @param sumMoney
     */
    @Override
    public void addMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoney();
        bank.setMoney(sum + sumMoney);
    }

    /**
     * Вычитание суммы денег со счета банка
     * @param bank
     * @param sumMoney
     * @return
     */
    @Override
    public Boolean subtractMoney(Bank bank, Double sumMoney) {
        Double sum = bank.getMoney();
        if (sumMoney > sum)
            return Boolean.FALSE;
        bank.setMoney(sum - sumMoney);
        return Boolean.TRUE;
    }

    /**
     * Вывод полной информации о банке, его офисах, банкоматах, сотрудниках и клиентах
     * @return
     */
    @Override
    public String getInfo() {
        StringBuilder returnStr = new StringBuilder(this.bank.toString());
        returnStr.append("\n\nОфисы банка:");
        for (int countOffice = 0; countOffice < this.bank.getOffices().size(); countOffice++) {
            returnStr.append(String.format("\n\n#%d\n", countOffice));
            returnStr.append(bank.getOffices().get(countOffice).toString());
        }
        returnStr.append("\n\nБанкоматы банка:");
        for (int countATM = 0; countATM < this.bank.getAtms().size(); countATM++) {
            returnStr.append(String.format("\n\n#%d\n", countATM));
            returnStr.append(bank.getAtms().get(countATM).toString());
        }
        returnStr.append("\n\nСотрудники банка:");
        for (int countEmployee = 0; countEmployee < this.bank.getEmployees().size(); countEmployee++) {
            returnStr.append(String.format("\n\n#%d\n", countEmployee));
            returnStr.append(bank.getEmployees().get(countEmployee).toString());
        }
        returnStr.append("\n\nКлиенты банка:");
        for (int countClient = 0; countClient < this.bank.getClients().size(); countClient++) {
            returnStr.append(String.format("\n\n#%d\n", countClient));
            returnStr.append(bank.getClients().get(countClient).toString());
        }
        return returnStr.toString();
    }
}
