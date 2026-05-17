import java.util.Scanner;

public class Problems {
    public void Pro3() {
        int sum = 0;
        for(int a= 1; a<=100; a++) {
            if(a % 3 == 0) {
                sum += a;
            }
        }
        System.out.println(sum);
    }
    public void Pro2() {
        String grade = "B";

        int score1 = 0;
        switch (grade) {
            case "A" -> {
                score1 = 100;
            }
            case "B" -> {
                int result = 100 - 20;
                score1 = result;
            }
            default -> {
                score1 = 60;
            }
        }
        System.out.println(score1);

    }

    public void Pro4() {
        int dice = 0;
        int dice1 = 0;
        int hap = 0;
        while (hap != 5) {
            dice = (int) (Math.random() * 6) + 1;
            dice1 = (int) (Math.random() * 6) + 1;
            hap = dice + dice1;
            System.out.println("(" + dice + "," + dice1 + ")");
        }
    }

    //3번 문제 do while 적용
    public void Pro4_1() {
        int hap1 = 0;
        int dice2 = 0;
        int dice3 = 0;
        do {
            dice2 = (int) (Math.random() * 6) + 1;
            dice3 = (int) (Math.random() * 6) + 1;
            hap1 = dice2 + dice3;
            System.out.println("(" + dice2 + "," + dice3 + ")");
        }
        while (hap1 != 5);
    }

    public void Pro5() {
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {

                if ((4 * x) + (5 * y) == 60) {
                    System.out.println("(" + x + "," + y + ")");

                }
            }

        }

    }

    public void Pro5_1() {
        int x1 = 1;
        do {
            int y1 = 1;
            do {
                if ((4 * x1) + (5 * y1) == 60) {
                    System.out.println("(" + x1 + "," + y1 + ")");
                }
                ++y1;
            } while (y1 <= 10);
            x1++;
        } while (x1 <= 10);
    }

    public void Pro6() {
        int i = 1;

        while (i <= 5) {
            int j = 1;

            while (j <= i) {
                System.out.print("*");
                j++;
            }

            System.out.println();
            i++;
        }
    }
    public void Pro6_1() {
        int i1 = 1;
        do {
            int j1 = 1;
            do {
                System.out.print("*");
                j1++;
            }while (j1 <= i1);

            System.out.println();
            i1++;
        }while (i1 <= 5);
    }
    public void Pro7() {
        Scanner scanner =  new Scanner(System.in);
        boolean flag = true;
        int money = 0;
        while (flag) {
            System.out.println("-----------------");
            System.out.println("1.예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("-----------------");
            System.out.print("선택> ");
            String strNum = scanner.nextLine();

            if (strNum.equals("1")) {
                money++;
                System.out.println("예금액> " + money);
            } else if (strNum.equals("2")) {
                money++;
                System.out.println("출금액> " + money);
            } else if (strNum.equals("3")) {
                money++;
                System.out.println("잔고> " + money);
            } else if (strNum.equals("4")) {
                flag = false;

            }
        }
    }
}
