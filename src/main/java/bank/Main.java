package bank;

import bank.entity.exceptions.*;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import bank.entity.status.StatusOffice;
import bank.service.BankService;
import bank.service.UserService;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final int countMaxBank = 5;
    static void lab3() throws CreditAccountException, PaymentAccountException, OfficeBankException, AtmBankException,
            EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException {
        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        ArrayList<UserServiceImpl> users = new ArrayList<>();
        for (int countBank = 0; countBank < 5; countBank++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(countBank, String.format("Банк %d", countBank));
            for (int countOffice = 0; countOffice < 3; countOffice++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(countOffice + countBank, String.format("Офис %d", countOffice), bankService.getBank(),
                        String.format("Космонавтов, дом %d", countOffice), StatusOffice.OPEN, 3500.0);
                for (int countEmployee = 0; countEmployee < 5; countEmployee++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(countEmployee + countOffice + countBank, String.format("Мария %d", countEmployee + countOffice + countBank),
                            "Денищук", LocalDate.of(2001, 10, 11), bankService
                                    .getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер %d", countEmployee), 40000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(countOffice + countBank, String.format("Банкомат %d", countOffice + countBank), StatusATM.OPEN, Boolean.TRUE,
                        Boolean.TRUE, 350.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(countBank, String.format("Екатерина %d", countBank), "Кузнецова", LocalDate.of(1973,
                    05, 07), String.format("Предприниматель %d", countBank));
            for (int countPaymentAccount = 0; countPaymentAccount < 2; countPaymentAccount++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 12, 05), 36, 5000.0);

                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }

        System.out.println("Банк");
        System.out.println(banks.get(0));
        System.out.println("\n\nКлиент");
        System.out.println(users.get(0));
    }

    static ArrayList<BankService> sortBanksByCriteria(ArrayList<BankService> banks, Double loanSum) {
        ArrayList<BankService> banksWithMoney = new ArrayList<>();
        ArrayList<Double> criteria = new ArrayList<>();
        for (BankService bank : banks) {
            if (bank.getBank().getMoney() >= loanSum) {
                banksWithMoney.add(bank);
                criteria.add(bank.getBank().getCountOffice() + bank.getBank().getCountATM() +
                        bank.getBank().getCountEmployees() + (20 - bank.getBank().getInterestRate()));
            }
        }
        for (int i = 0; i < criteria.size(); i++) {
            for (int j = 0; j < criteria.size(); j++) {
                if (criteria.get(j) < criteria.get(i)) {
                    Double crit = criteria.get(i);
                    BankService bank = banksWithMoney.get(i);

                    criteria.set(i, criteria.get(j));
                    banksWithMoney.set(i, banksWithMoney.get(j));
                    criteria.set(j, crit);
                    banksWithMoney.set(j, bank);
                }
            }
        }
        return banksWithMoney;
    }

    static void NevmovenkoMA_lab3() throws CreditAccountException, PaymentAccountException, OfficeBankException, AtmBankException,
            EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException, CreditException,
            LowRatingUserException {
        ArrayList<BankService> banks = new ArrayList<>();
        ArrayList<UserService> users = new ArrayList<>();
        for (int countBank = 0; countBank < 5; countBank++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(countBank, String.format("Банк %d", countBank));
            for (int countOffice = 0; countOffice < 3; countOffice++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(countOffice + countBank, String.format("Офис %d", countOffice), bankService.getBank(),
                        String.format("60 лет октября, дом %d", countOffice), StatusOffice.OPEN, 3500.0);
                bankOfficeService.addMoney(bankService.getBank().getMoney()/3);
                for (int countEmployee = 0; countEmployee < 5; countEmployee++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(countEmployee + 5 * countOffice + 3 * countBank, String.format("Михаил %d", countEmployee + 5 * countOffice
                                    + 3 * countBank), "Невмовенко",
                            LocalDate.of(2001, 10, 11), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер %d", countEmployee), 40000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(countOffice + countBank, String.format("Банкомат %d", countOffice + countBank), StatusATM.OPEN, Boolean.TRUE,
                        Boolean.TRUE,
                        350.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                atmService.addMoney(bankOfficeService.getBankOffice().getMoney());
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(countBank, String.format("Олег %d", countBank), "Тинькоф", LocalDate.of(1973,
                    05, 07), String.format("Предприниматель %d", countBank));
            for (int countPaymentAccount = 0; countPaymentAccount < 2; countPaymentAccount++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(countPaymentAccount + countBank, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 12, 05), 35, 4500.0);

                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }

        System.out.println("Клиент");
        UserService workUser = users.get(0);
        System.out.println(workUser.getUser());
        System.out.println("\nПопытка получения нового кредита");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму кредита: ");
        double loanSum = input.nextDouble();
        System.out.println("Введите количество месяцев: ");
        int countMonth = input.nextInt();
        ArrayList<BankService> banksWithMoney = sortBanksByCriteria(banks, loanSum);
        System.out.println("\nПредложенные банки:");
        for (int countBank = 0; countBank < banksWithMoney.size(); countBank++) {
            if (countBank != 0) {
                System.out.printf("\nБанк %d%n", countBank +1);
            }
            else {
                System.out.printf("Банк %d%n", countBank +1);
            }
            System.out.println(banksWithMoney.get(countBank).getBank());
        }
        System.out.println("\nВыберите из предложенных банков: ");
        int bankID = input.nextInt();
        BankService workBank = banksWithMoney.get(bankID - 1);

        System.out.println("\nПредложенные банковские офисы:");
        for (int countOffice = 0; countOffice < workBank.getBank().getOffices().size(); countOffice++) {
            if (countOffice != 0) {
                System.out.printf("\nОфис %d%n", countOffice +1);
            }
            else {
                System.out.printf("Офис %d%n", countOffice +1);
            }
            System.out.println(workBank.getBank().getOffices().get(countOffice));
        }
        System.out.println("\nВыберите из предложенных офисов: ");
        int officeID = input.nextInt();
        BankOffice workOffice = workBank.getBank().getOffices().get(officeID - 1);

        System.out.println("\nПредложенные сотрудники:");
        for (int countEmployee = 0; countEmployee < workOffice.getEmployees().size(); countEmployee++) {
            if (countEmployee != 0) {
                System.out.printf("\nСотрудник %d%n", countEmployee +1);
            }
            else {
                System.out.printf("Сотрудник %d%n", countEmployee +1);
            }
            System.out.printf("id %d%n", workOffice.getEmployees().get(countEmployee).getId());
            System.out.printf("Имя %s", workOffice.getEmployees().get(countEmployee).getName());
            if (workOffice.getEmployees().get(countEmployee).getCanIssue()) {
                System.out.println("\nМожет выдавать кредиты");
            }
            else {
                System.out.println("\nНе может выдавать кредиты");
            }
        }
        System.out.println("\nВыберите из предложенных сотрудников: ");
        int employeeID = input.nextInt();
        Employee workEmployee = workOffice.getEmployees().get(employeeID);
        //Берём кредит
        PaymentAccountServiceImpl payAcc = new PaymentAccountServiceImpl();
        CreditAccountServiceImpl creditAcc = new CreditAccountServiceImpl();
        workUser.applyForLoan(workBank, workOffice, workEmployee, workOffice.getBankATMS().get(0), loanSum,
                LocalDate.of(2022, 12, 05), countMonth, payAcc, creditAcc);
        System.out.println("Кредит успешно оформлен.");
        int size = workUser.getUser().getCreditAccounts().size();
        System.out.println(workUser.getUser().getCreditAccounts().get(size - 1));
    }

    public static void main(String[] args) throws CreditAccountException, PaymentAccountException, OfficeBankException,
            AtmBankException, EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException,
            CreditException, LowRatingUserException {
        NevmovenkoMA_lab3();
    }
}