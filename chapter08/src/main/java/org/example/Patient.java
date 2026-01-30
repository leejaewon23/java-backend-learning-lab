package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class Patient {
    private String name; //동물 환자 이름
    private String kind; //동물 종류
    private String number; //식별번호
    private String firstDate; //입원 날짜
    private String lastDate; //퇴원 날짜
    private String doctorName; // 의사 이름
    private String ownerName; //주인이름
    private int joinNumber; //면회 횟수

    public void checkVisitation(String visitorName, int hour) {
        if (!visitorName.equals(this.ownerName)) {
            System.out.println("면회 불가: 주인만 면회가 가능합니다.");
            return;
        }

        if (hour >= 15 && hour <= 20) {
            System.out.println(ownerName + "님, " + name + "와의 면회가 시작되었습니다.");
        } else {
            System.out.println("면회 불가: 면회 시간(15시~20시)이 아닙니다.");
        }
    }

}
