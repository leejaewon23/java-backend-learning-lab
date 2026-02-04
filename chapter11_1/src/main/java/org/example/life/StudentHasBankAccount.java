package org.example.life;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.banking.BankAccount;
import org.example.student.Student;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHasBankAccount {
	private final Student student;
	private final BankAccount bankAccount;

        //계좌에 돈을 입금
        public void income(int money) {
            bankAccount.setMoney(money + bankAccount.getMoney());
        }
        //계좌에 돈을 출금
        public void outcome(int money) {
            bankAccount.setMoney(bankAccount.getMoney() - money);
        }

        //계좌의 현재 금액을 리턴
        public int getCurrentMoney() {
            return this.bankAccount.getMoney();
        }
    }
