package org.example;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int sum;


    public static void main(String[] args) throws Exception {
        //set 컬렉션 생성
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        //Stream을 이용한 요소 반복 처리
        Stream<String> stream = set.stream();
        stream.forEach( name -> System.out.println(name));

        //List 컬렉션 생성
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("람다식");
        list.add("박병렬");

        //병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach ( name -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        });

        List<Student> list2 = Arrays.asList(
                new Student("홍딜동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        double avg = list2.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();

        System.out.println("평균 점수: " + avg);

        //List 컬렉션 생성
        List<Product>  list3 = new ArrayList<>();
        for(int i = 1; i<=5; i++) {
            Product product = new Product(i, "상품" + i, "멋진 회사", (int) (10000*Math.random()));
            list3.add(product);
        }

        //객체 스트림 얻기
        Stream<Product> stream3 = list3.stream();
        stream3.forEach(p -> System.out.println(p));

        String[] strArray = {"홍길동", "신용권", "김미나"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(item -> System.out.print(item + ","));
        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(item -> System.out.print(item + ","));
        System.out.println();

        //숫자 범위로부터 스트림 얻기
        IntStream stream1 = IntStream.rangeClosed(1, 100);
        stream1.forEach(a -> sum += a);
        System.out.println("총합: " + sum);

        //파일로부터 스트림 얻기
        Path path = Paths.get(Main.class.getResource("/data.txt").toURI());
        Stream<String> stream2 = Files.lines(path, Charset.defaultCharset());
        stream2.forEach(line -> System.out.println(line));
        stream2.close();

        



    }
}