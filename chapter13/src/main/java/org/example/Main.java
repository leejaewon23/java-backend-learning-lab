package org.example; //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import GenericMethod.Box1;
import GenericType.*;

import static GenericMethod.GenericExample1.boxing;
import static org.example.GenericType.compare;

public class Main {
    public static void main(String[] args) {
        MainPackaging mp = new MainPackaging();
        mp.doSome();

        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요";
        String str = box1.content;
        System.out.println(str);

        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        int value = box2.content;
        System.out.println(value);

        //K는 Tv로 대체, M은 String으로 대체
        Product<Tv, String> product1 = new Product<>();

        //Setter 매개값은 반드시 Tv와 String을 제공
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");

        //Getter 리턴값은 Tv와 String이 됨
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        //K는 Car로 대체, M은 String으로 대체
        Product<Car, String> product2 = new Product<>();

        //Setter 매개값은 반드시 Car와 String을 제공
        product2.setKind(new Car());
        product2.setModel("SUV 자동차");

        //Getter 리턴값은 Car와 String이 됨
        Car car = product2.getKind();
        String carModel = product2.getModel();

        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Car car1 = carAgency.rent();
        car1.run();

        Box<String> box3 = new Box<>();
        box3.content = "100";

        Box<String> box4 = new Box<>();
        box4.content = "100";

        boolean result = box3.compare(box4);
        System.out.println("result: " + result);

        Box1<Integer> box6 = boxing(100);
        int intValue = box6.get();
        System.out.println(intValue);

        Box1<String> box5 = boxing("홍길동");
        String strValue = box5.get();
        System.out.println(strValue);

        //제네릭 메소드 호출
        boolean result1 = compare(10,20);
        System.out.println(result1);
        System.out.println();

        //제네릭 메소드 호출
        boolean result2 = compare(4.5, 4.5);
        System.out.println(result2);

        //모든 사람이 신청 가능
        Course.registerCourse1(new Applicant<Person>(new Person()));
        Course.registerCourse1(new Applicant<Worker>(new Worker()));
        Course.registerCourse1(new Applicant<Student>(new Student()));
        Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        Course.registerCourse2(new Applicant<Student>(new Student()));
        Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();

        //직장인 및 일반인만 신청 가능
        Course.registerCourse3(new Applicant<Person>(new Person()));
        Course.registerCourse3(new Applicant<Worker>(new Worker()));

        



    }
}