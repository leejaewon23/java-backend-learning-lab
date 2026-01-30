package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Nurse {
    private String nurseName;

    // 동작: 투약 관리 (하루 3번, 이름과 식별번호로 구분)
    public void administerMedicine(Patient patient, int round) {
        if (round < 1 || round > 3) {
            System.out.println("투약 시간이 아닙니다. (1~3회차만 가능)");
            return;
        }
        System.out.println("[투약 " + round + "회차] 간호사 " + nurseName + "가 환자 [" +
                patient.getName() + "(ID: " + patient.getNumber() + ")]에게 약을 먹였습니다.");
    }
}