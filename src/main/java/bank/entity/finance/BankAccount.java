package bank.entity.finance;

import bank.entity.man.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract public class BankAccount {
        private Integer id;
        private User user;
        private Bank bank;

        public BankAccount(Integer id, User user, Bank bank){
            this.id = id;
            this.user = user;
            this.bank = bank;
        }
}

