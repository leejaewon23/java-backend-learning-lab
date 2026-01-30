package org.example;

public class Main {
    public static void main(String[] args) {
        Mjc813Student m813 = new Mjc813Student();
        m813.study();

        //인터페이스 변수 선언
        RemoteControl rc;

        //Television 객체를 생성하고 인터페이스 변수에 대입
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        //디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        //Audio 객체를 생성하고 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        rc.setMute(true);
        rc.setMute(false);

        System.out.println("리모콘 최대 볼륨: " + RemoteControl.MAX_VOLUME);
        System.out.println("리모콘 최저 볼륨: " + RemoteControl.MIN_VOLUME);

        //정적 메소드 호출
        RemoteControl.changeBattery();

        //인터페이스 변수 선언과 구현 객체 대입
        Service service = new ServiceImpl();

        //디폴트 메소드 호출
        service.defaultMethod1();
        System.out.println();
        service.defaultMethod2();
        System.out.println();

        //정적 메소드 호출
        Service.staticMethod1();
        System.out.println();
        Service.staticMethod2();
        System.out.println();

        //RemoteControl1 인터페이스 변수 선언 및 구현 객체 대입
        RemoteControl1 rc1 = new SmartTelevision();
        //RemoteControl1 인터페이스에 선언된 추상 메소드만 호출 가능
        rc1.turnOn();
        rc1.turnOff();
        //Serchable 인터페이스 변수 선언 및 구현 객체 대입
        Searchable searchable = new SmartTelevision();
        //Serchable 인터페이스에 선언된 추상 메소드만 호출 가능
        searchable.search("https:www.youtube.com");

        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        System.out.println();

        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();

        //연습문제 5번
        Remocon r = new TV();
        r.powerOn();

        //연습문제 6번
        SoundableExample.printSound(new Cat());
        SoundableExample.printSound(new Dog());

        //연습문제 7번
        DataAccessObject.dbWork(new OracleDao());
        DataAccessObject.dbWork(new MySqlDao());

        //연습문제 8번
        Example.action(new B());
        Example.action(new C());

        //개인 과제 1번

        // 1. 동물 환자 객체 생성 (Patient)
        // 인자 순서: 이름, 종류, 식별번호, 입원일, 퇴원일, 의사명, 주인명, 면회횟수
        Patient myPatient = new Patient(
                "나비",
                "고양이",
                "C-001",
                "25-12-11",
                "26-01-30",
                "김닥터",
                "이재원",
                0
        );

        // 2. 간호사 객체 생성 및 투약 업무 수행 (Nurse)
        Nurse myNurse = new Nurse("김간호사");

        System.out.println("=== 투약 관리 업무 ===");
        myNurse.administerMedicine(myPatient, 1); // 1회차 투약
        myNurse.administerMedicine(myPatient, 2); // 2회차 투약
        myNurse.administerMedicine(myPatient, 4); // 잘못된 회차 입력 시 예외 문구 출력

        System.out.println("\n=== 면회 관리 업무 ===");
        // 3. 면회 시도 (Patient 클래스의 로직 활용)
        // 상황 1: 주인이 아닌 사람이 면회 올 때
        myPatient.checkVisitation("홍길동", 16);

        // 상황 2: 주인이 면회 시간 외에 올 때 (15시~20시가 아님)
        myPatient.checkVisitation("이찬혁", 10);

        // 상황 3: 주인이 정상 시간에 면회 올 때
        myPatient.checkVisitation("이재원", 17);

        //2번 문제 상속
        CatPatient c1 = new CatPatient("나비",
                "고양이",
                "C-001",
                "25-12-11",
                "26-01-30",
                "김닥터",
                "이재원",
                0);
        c1.checkVisitation("이재원", 20);
    }


}