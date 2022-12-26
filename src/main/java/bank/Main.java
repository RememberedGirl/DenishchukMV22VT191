package bank;

import bank.entity.exceptions.*;
import bank.entity.finance.BankOffice;
import bank.entity.man.Employee;
import bank.entity.status.StatusATM;
import bank.entity.status.StatusOffice;
import bank.service.BankService;
import bank.service.UserService;
import bank.service.impl.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void Denishchuk_lab1() {
        //Bank
        System.out.println("Банк>:");
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.create(1, "Сбербанк");
        System.out.println(bankService.getBank());

        //Bank Office
        System.out.println("\n\nОфис Банка:");
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        bankOfficeService.create(1, "Сбербанк №1", bankService.getBank(), "Спортивная 9г",
                StatusOffice.OPEN, 3500.0);
        System.out.println(bankOfficeService.getBankOffice());

        //Employee
        System.out.println("\n\nРаботник:");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.create(1, "Мария", "Денищук", LocalDate.of(2001, 10,
                        11),
                bankService.getBank(), bankOfficeService.getBankOffice(), "Менеджер", 35000.0);
        System.out.println(employeeService.getEmployee());

        //Bank ATM
        System.out.println("\n\nБанкомат банка:");
        AtmServiceImpl atmService = new AtmServiceImpl();
        atmService.create(1, "СБЕР Банкомат ", StatusATM.OPEN, Boolean.TRUE, Boolean.TRUE,
                350.0, bankService.getBank(), bankOfficeService.getBankOffice(),
                employeeService.getEmployee());
        System.out.println(atmService.getBankATM());

        //User
        System.out.println("\n\nПользователь:");
        UserServiceImpl userService = new UserServiceImpl();
        userService.create(1, "Павел", "Денищук", LocalDate.of(1995, 9,
                        2),
                "Разработчик JAVA");
        System.out.println(userService.getUser());

        //Payment Account
        System.out.println("\n\nПлатежный аккаунт:");
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        paymentAccountService.create(1, userService.getUser(), bankService.getBank());
        System.out.println(paymentAccountService.getPayAcc());

        //Credit Account
        System.out.println("\n\nКредитный аккаунт:");
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        creditAccountService.create(1, userService.getUser(), bankService.getBank(), employeeService.getEmployee(),
                paymentAccountService.getPayAcc(), LocalDate.of(2022, 11, 11), 12,
                150.0);
        System.out.println(creditAccountService.getCreditAcc());
    }

    static void Denishcuk_lab2() throws  OfficeBankException, AtmBankException,
            EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException, PaymentAccountException, CreditAccountException {
        ArrayList<BankServiceImpl> banks = new ArrayList<>();
        ArrayList<UserServiceImpl> users = new ArrayList<>();
        for (int count_bankServices = 0; count_bankServices < 5; count_bankServices++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(count_bankServices, String.format("Банк №%d", count_bankServices));
            for (int count_bankOffices = 0; count_bankOffices < 3; count_bankOffices++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(count_bankOffices + count_bankServices, String.format("Офис №%d", count_bankOffices), bankService.getBank(),
                        String.format("Спортиная %dд", count_bankOffices), StatusOffice.OPEN, 3000.0);
                for (int count_employees = 0; count_employees < 5; count_employees++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(count_employees + count_bankOffices + count_bankServices, String.format("Мария %d", count_employees + count_bankOffices + count_bankServices),
                            "Денищук", LocalDate.of(2001, 10, 11), bankService
                                    .getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер №%d", count_employees), 35000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(count_bankOffices + count_bankServices, String.format("Банкомат %d", count_bankOffices + count_bankServices), StatusATM.OPEN, Boolean.TRUE,
                        Boolean.TRUE, 350.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(count_bankServices, String.format("Павел %d", count_bankServices), "Денищук", LocalDate.of(1995,
                    9, 2), String.format("Разработчик JAVA%d", count_bankServices));
            for (int count_paymentAccounts = 0; count_paymentAccounts < 2; count_paymentAccounts++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);

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

    static void Denishchuk_lab3() throws CreditAccountException, PaymentAccountException, OfficeBankException, AtmBankException,
            EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException, CreditException,
            LowRatingUserException {
        ArrayList<BankService> banks = new ArrayList<>();
        ArrayList<UserService> users = new ArrayList<>();
        for (int count_bankServices = 0; count_bankServices < 5; count_bankServices++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(count_bankServices, String.format("Банк %d", count_bankServices));
            for (int count_bankOffices = 0; count_bankOffices < 3; count_bankOffices++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(count_bankOffices + count_bankServices, String.format("Офис №%d", count_bankOffices), bankService.getBank(),
                    String.format("Спортивная 7%dд", count_bankOffices), StatusOffice.OPEN, 3500.0);
                bankOfficeService.addMoney(bankService.getBank().getMoney()/3);
                for (int count_employees = 0; count_employees < 5; count_employees++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(count_employees + 5 * count_bankOffices + 3 * count_bankServices, String.format("Мария %d", count_employees + 5 * count_bankOffices
                                    + 3 * count_bankServices), "Денищук",
                            LocalDate.of(2001, 10, 11), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер №%d", count_employees), 35000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(count_bankOffices + count_bankServices, String.format("Банкомат %d", count_bankOffices + count_bankServices), StatusATM.OPEN, Boolean.TRUE,
                        Boolean.TRUE,
                        350.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                atmService.addMoney(bankOfficeService.getBankOffice().getMoney());
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(count_bankServices, String.format("Павел %d", count_bankServices), "Денищук", LocalDate.of(1996,
                    9, 2), String.format("Разработчик JAVA %d", count_bankServices));
            for (int count_paymentAccounts = 0; count_paymentAccounts < 2; count_paymentAccounts++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);

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
        for (int i = 0; i < banksWithMoney.size(); i++) {
            if (i != 0) {
                System.out.printf("\nБанк №%d%n", i+1);
            }
            else {
                System.out.printf("Банк №%d%n", i+1);
            }
            System.out.println(banksWithMoney.get(i).getBank());
        }
        System.out.println("\nВыберите из предложенных банков: ");
        int bankID = input.nextInt();
        BankService workBank = banksWithMoney.get(bankID - 1);

        System.out.println("\nПредложенные банковские офисы:");
        for (int i = 0; i < workBank.getBank().getOffices().size(); i++) {
            if (i != 0) {
                System.out.printf("\nОфис №%d%n", i+1);
            }
            else {
                System.out.printf("Офис №%d%n", i+1);
            }
            System.out.println(workBank.getBank().getOffices().get(i));
        }
        System.out.println("\nВыберите из предложенных офисов: ");
        int officeID = input.nextInt();
        BankOffice workOffice = workBank.getBank().getOffices().get(officeID - 1);

        System.out.println("\nПредложенные сотрудники:");
        for (int i = 0; i < workOffice.getEmployees().size(); i++) {
            if (i != 0) {
                System.out.printf("\nСотрудник №%d%n", i+1);
            }
            else {
                System.out.printf("Сотрудник №%d%n", i+1);
            }
            System.out.printf("id %d%n", workOffice.getEmployees().get(i).getId());
            System.out.printf("Имя %s", workOffice.getEmployees().get(i).getName());
            if (workOffice.getEmployees().get(i).getCanIssue()) {
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
                LocalDate.of(2022, 11, 11), countMonth, payAcc, creditAcc);
        System.out.println("Кредит успешно оформлен.");
        int size = workUser.getUser().getCreditAccounts().size();
        System.out.println(workUser.getUser().getCreditAccounts().get(size - 1));
    }

    static void Denishchuk_lab4() throws CreditException, PaymentAccountException, OfficeBankException, AtmBankException,
            EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException, CreditAccountException, IOException {
        ArrayList<BankService> banks = new ArrayList<>();
        ArrayList<UserService> users = new ArrayList<>();
        for (int count_bankServices = 0; count_bankServices < 5; count_bankServices++) {
            BankServiceImpl bankService = new BankServiceImpl();
            bankService.create(count_bankServices, String.format("Банк №%d", count_bankServices));
            for (int count_bankOffices = 0; count_bankOffices < 3; count_bankOffices++) {
                BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
                bankOfficeService.create(count_bankOffices + count_bankServices, String.format("Офис №%d", count_bankOffices), bankService.getBank(),
                        String.format("Спортивная %dа", count_bankOffices), StatusOffice.OPEN, 3500.0);
                bankOfficeService.addMoney(bankService.getBank().getMoney()/3);
                for (int count_employees = 0; count_employees < 5; count_employees++) {
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    employeeService.create(count_employees + 5 * count_bankOffices + 3 * count_bankServices, String.format("Мария %d", count_employees + 5 * count_bankOffices
                                    + 3 * count_bankServices), "Денищук",
                            LocalDate.of(2001, 10, 11), bankService.getBank(),
                            bankOfficeService.getBankOffice(), String.format("Менеджер №%d", count_employees), 35000.0);
                    bankOfficeService.addEmployee(employeeService);
                    bankService.addEmployee(employeeService);
                }
                AtmServiceImpl atmService = new AtmServiceImpl();
                atmService.create(count_bankOffices + count_bankServices, String.format("Банкомат %d", count_bankOffices + count_bankServices), StatusATM.OPEN, Boolean.TRUE,
                        Boolean.TRUE,
                        350.0, bankOfficeService.getBankOffice().getBank(),
                        bankOfficeService.getBankOffice(), bankOfficeService.getBankOffice().getEmployees().get(1));
                atmService.addMoney(bankOfficeService.getBankOffice().getMoney());
                bankOfficeService.addBankATM(atmService);
                bankService.addBankATM(atmService);
                bankService.addBankOffice(bankOfficeService);
            }

            UserServiceImpl userService = new UserServiceImpl();
            userService.create(count_bankServices, String.format("Павел %d", count_bankServices), "Денищук", LocalDate.of(1996,
                    9, 2), String.format("Разработчик JAVA %d", count_bankServices));
            for (int count_paymentAccounts = 0; count_paymentAccounts < 2; count_paymentAccounts++) {
                PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
                paymentAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank());

                CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
                creditAccountService.create(count_paymentAccounts + count_bankServices, userService.getUser(), bankService.getBank(),
                        bankService.getBank().getEmployees().get(1), paymentAccountService.getPayAcc(),
                        LocalDate.of(2022, 11, 11), 12, 150.0);

                userService.addPayAcc(paymentAccountService);
                userService.addCreditAcc(creditAccountService);
            }
            bankService.addUser(userService);
            banks.add(bankService);
            users.add(userService);
        }
        try {
            users.get(0).downloadToFile("file.txt", banks.get(0));
            System.out.println("\tbefore writing to file\nПлатёжные счета :");
            System.out.println(users.get(0).getUser().getPaymentAccounts());
            System.out.println("\n\tbefore writing to file\nКредитные счета :");
            System.out.println(users.get(0).getUser().getCreditAccounts());
            users.get(0).downloadFromFile("file.txt");
            System.out.println("\n\n\n\tafter reading from file\nПлатёжные счета :");
            System.out.println(users.get(0).getUser().getPaymentAccounts());
            System.out.println("\n\tafter reading from file\nКредитные счета :");
            System.out.println(users.get(0).getUser().getCreditAccounts());
        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e);
        }
    }

    public static void main(String[] args) throws CreditAccountException, PaymentAccountException, OfficeBankException,
            AtmBankException, EmployeeBankException, UserBankException, AtmOfficeException, EmployeeOfficeException,
            CreditException, IOException {
        Denishchuk_lab4();
    }
}