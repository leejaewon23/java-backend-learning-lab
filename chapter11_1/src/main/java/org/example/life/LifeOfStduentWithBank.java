package org.example.life;

import lombok.RequiredArgsConstructor;
import org.example.banking.BankAccount;
import org.example.banking.IMachine;
import org.example.banking.MachineNotWorkingException;
import org.example.banking.SendMachine;
import org.example.student.Student;


@RequiredArgsConstructor
public class LifeOfStduentWithBank {
    private final IMachine machine;

	public void doToday() {
		Student lsh = new Student("이승협", "lsh2928");
		Student cwc = new Student("최원철", "csc9292");

		BankAccount ba1 = new BankAccount("1111-1111-11", "이승협");
		BankAccount ba2 = new BankAccount("222-222-2222", "최원철");

		StudentHasBankAccount lshBank = new StudentHasBankAccount(lsh, ba1);
		StudentHasBankAccount cwcBank = new StudentHasBankAccount(cwc, ba2);

        this.sendMoney(lshBank, cwcBank, 100000);
        this.sendMoney(cwcBank, lshBank, 5000);
	}

    public void sendMoney(StudentHasBankAccount from, StudentHasBankAccount to, int money) {
        // 원하는 곳에 예외처리 하세요
        SendMachine sm = new SendMachine();
        // from 뱅크에서 money 를 빼낸다.
        from.outcome(money);
        // 과제
        try {
            if (this.machine.isActive()) {
                // to 뱅크로 money 를 추가한다.
                to.income(money);
                // 과제
            } else {
                to.income(money);
            }
        } catch (MachineNotWorkingException e) {
            System.err.println(e.getMessage());
            from.income(money);
        }
    }
}
