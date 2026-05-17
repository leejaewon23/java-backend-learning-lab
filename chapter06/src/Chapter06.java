public class Chapter06 {
    public void StudentExample() {
        Student s1 = new Student();
        System.out.println("s1 변수가 Student 객체를 참조합니다.");

        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
    }

    public void CarExample() {
        Car myCar = new Car();

        System.out.println("모델명: " + myCar.model);
        System.out.println("시동여부: " + myCar.start);
        System.out.println("현재속도: " + myCar.speed);
    }

    public void CarExample1() {
        Car1 myCar1 = new Car1();

        System.out.println("제작회사: " + myCar1.company);
        System.out.println("모델명: " + myCar1.model);
        System.out.println("색깔: " + myCar1.color);
        System.out.println("최고속도: " + myCar1.maxSpeed);
        System.out.println("현재속도: " + myCar1.speed);

        myCar1.speed = 60;
        System.out.println("수정된 속도: " + myCar1.speed);
    }

    //필드 초기화
    public void KoreanExample() {
        Korean k1 = new Korean("박자바", "011225-1234567");
        System.out.println("k1.nation : " + k1.nation);
        System.out.println("k1.name : " + k1.name);
        System.out.println("k1.ssn : " + k1.ssn);
        System.out.println();

        Korean k2 = new Korean("김자바", "930525-0654321");
        System.out.println("k2.nation : " + k2.nation);
        System.out.println("k2.name : " + k2.name);
        System.out.println("k2.ssn : " + k2.ssn);
    }

    public void CarExample2() {
        Car2 car1 = new Car2();
        System.out.println("car1.company : " + car1.company);
        System.out.println();

        Car2 car2 = new Car2("자가용");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();

        Car2 car3 = new Car2("자가용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();

        Car2 car4 = new Car2("택시", "검정", 200);
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
    }

    public void CarExample3() {
        Car3 car1 = new Car3("자가용");
        System.out.println("car1.company : " + car1.company);
        System.out.println("car1.model : " + car1.model);
        System.out.println();

        Car3 car2 = new Car3("자가용", "빨강");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println("car2.color : " + car2.color);
        System.out.println();

        Car3 car3 = new Car3("택시", "검정", 200);
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println("car3.maxSpeed : " + car3.maxSpeed);
    }

    public void CalculatorExample() {
        Calculator myCalc = new Calculator();

        myCalc.powerOn();

        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);

        int x = 10;
        int y = 4;

        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);

        myCalc.powerOff();
    }

    public void ComputerExample() {
        Computer myCom = new Computer();

        int result1 = myCom.sum(1, 2, 3);
        System.out.println("result1: " + result1);

        int result2 = myCom.sum(1, 2, 3, 4, 5);
        System.out.println("result2: " + result2);

        int[] values = {1, 2, 3, 4, 5};
        int result3 = myCom.sum(values);
        System.out.println("result3: " + result3);

        int result4 = myCom.sum(new int[] {1, 2, 3, 4, 5});
        System.out.println("result4: " + result4);

    }

    public void CarExample4() {
        Car4 myCar = new Car4();

        myCar.setGas(5);

        if(myCar.isLeftGas()) {
            System.out.println("출발합니다.");
            //리턴값이 없는 run() 메소드 호출
            myCar.run();
        }
        System.out.println("gas를 주입하세요.");
    }

    public void CalculatorExample1() {
        Calculator1 myCalc = new Calculator1();

        double result1 = myCalc.areaRectangle(10);

        double result2 = myCalc.areaRectangle(10, 20);

        System.out.println("정사각형 넓이=" + result1);
        System.out.println("직사각형 넓이=" + result2);
    }

    // 과제2
    public void PhoneExample() {
        Phone p1 = new Phone("갤럭시", "S25+", "블랙");
        System.out.println("브렌드: " + p1.brand);
        System.out.println("모델: " + p1.model);
        System.out.println("색상: " + p1.color);
        System.out.println("------------------");

        Phone p2 = new Phone("아이폰", "14 Pro", "화이트");
        System.out.println("브렌드: " + p2.brand);
        System.out.println("모델: " + p2.model);
        System.out.println("색상: " + p2.color);
        System.out.println("------------------");
    }

    //과제3
    public void GameExample() {
        Game g1 = new Game("마리오 카트", "액션", "전체 이용", 50000, "https://www.nintendo.com/kr/?srsltid=AfmBOorKeYiGZ5kWJDdGaJq9xJnR1wd8qUABoUKwzwkE4KD7XSEaInYX");

        System.out.println("게임 제목: " + g1.title);
        System.out.println("장르: " + g1.type);
        System.out.println("등급: " + g1.limit);
        System.out.println("가격: " + g1.price + "원");
        System.out.println("이미지주소: " + g1.address);
        System.out.println("------------------------");

        Game g2 = new Game("별의 커피", "전략", "전체 이용", 45000, "https://www.nintendo.com/kr/?srsltid=AfmBOorKeYiGZ5kWJDdGaJq9xJnR1wd8qUABoUKwzwkE4KD7XSEaInYX");

        System.out.println("게임 제목: " + g2.title);
        System.out.println("장르: " + g2.type);
        System.out.println("등급: " + g2.limit);
        System.out.println("가격: " + g2.price + "원");
        System.out.println("이미지주소: " + g2.address);
    }

    //과제4
    public void GameExample2() {
        GameCharacter c1 = new GameCharacter("도적고양이", "도적", "여자", 203, 395, 20210101);
        System.out.println("------------------------");
        System.out.println("이름: " + c1.name);
        System.out.println("직업: " + c1.job);
        System.out.println("성별: " + c1.sex);
        System.out.println("HP: " + c1.hp);
        System.out.println("MP: " + c1.mp);
        System.out.println("생일: " + c1.birthday);

        GameCharacter c2 = new GameCharacter("신사임걸", "마법사", "여자", 203, 395, 20230801);
        System.out.println("------------------------");
        System.out.println("이름: " + c2.name);
        System.out.println("직업: " + c2.job);
        System.out.println("성별: " + c2.sex);
        System.out.println("HP: " + c2.hp);
        System.out.println("MP: " + c2.mp);
        System.out.println("생일: " + c2.birthday);
    }

    //25.01.26
    //과제1 chapter06 p245~p277 예제
    public void Car5Example() {
        Car5 myCar = new Car5("포르쉐");
        Car5 myCar2 = new Car5("벤츠");

        myCar.run();
        myCar2.run();
    }



}









