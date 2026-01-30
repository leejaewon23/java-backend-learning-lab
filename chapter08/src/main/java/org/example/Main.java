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





    }
}