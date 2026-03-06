package org.example;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
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

        //요소 걸러내기(필터링)
        //List 컬렉션 생성
        List<String> list1 = new ArrayList<>();
        list1.add("홍길동");
        list1.add("신용권");
        list1.add("김자바");
        list1.add("신용권");
        list1.add("신민철");

        //중복 요소 제거
        list1.stream()
                .distinct()
                .forEach(n -> System.out.println(n));
        System.out.println();

        //신으로 시작하는 요소만 필터링
        list1.stream()
                .filter(n -> n.startsWith("신"))
                .forEach(n -> System.out.println(n));
        System.out.println();

        //중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
        list1.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                .forEach(n -> System.out.println(n));
        System.out.println();

        //요소 변환(매핑)
        //요소를 다른 요소로 변환

        //List 컬렉션 생성
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 85));
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("홍길동", 87));

        //Student를 score 스트림으로 변환
        studentList.stream()
                .mapToInt(s -> s.getScore())
                .forEach(score -> System.out.println(score));

        int[] intArray1 = {1, 2, 3, 4, 5};

        IntStream intStream1 = Arrays.stream(intArray1);
        intStream1
                .asDoubleStream()
                .forEach(d -> System.out.println(d));

        System.out.println();

        intStream1 = Arrays.stream(intArray1);
        intStream1
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));

        //요소를 복수 개의 요소로 변환
        //문장 스트림을 단어 스트림으로 변환
        List<String> list4 = new ArrayList<>();
        list4.add("this is java");
        list4.add("i am a best developer");
        list4.stream().
                flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        //문자열 숫자 목록 스트림을 숫자 스트림으로 변환
        List<String> list5 = Arrays.asList("10, 20, 30, 40, 50");
        list5.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));

        //요소 정렬
        //Comparable 구현 객체의 정렬

        //List 컬렉션 생성
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student("홍길동", 30));
        studentList1.add(new Student("신용권", 10));
        studentList1.add(new Student("유미선", 20));

        //점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList1.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        //점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList1.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        //Comparator를 이용한 정렬
        //List 컬렉션 생성
        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(new Student("홍길동", 30));
        studentList2.add(new Student("신용권", 10));
        studentList2.add(new Student("유미선", 20));

        //점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList2.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        //점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList2.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

        //요소를 하나씩 처리(루핑)
        int[] intArr = {1, 2, 3, 4, 5};

        //잘못 작성한 경우
        Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .peek(n -> System.out.println(n)); //최종 처리가 없으므로 동작하지 않음

        //중간 처리 메소드 peek()을 이용해서 반복 처리
        int total = Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .peek(n -> System.out.println(n)) //동작함
                .sum();
        System.out.println("총합: " + total + "\n");

        //최종 처리 메소드 forEach()를 이용해서 반복 처리
        Arrays.stream(intArr)
                .filter(a -> a%2==0)
                .forEach(n -> System.out.println(n)); //최종 처리이므로 동작함

        //요소 조건 만족 여부(매칭)
        int[] intArr2 = { 2, 4, 6};

        boolean result = Arrays.stream(intArr2)
                .anyMatch(a -> a%2==0);
        System.out.println("모두 2의 배수인가? " + result);

        result = Arrays.stream(intArr2)
                .anyMatch(a -> a%3==0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr2)
                .noneMatch(a -> a%3==0);
        System.out.println("3의 배수가 없는가? " + result);

        //요소 기본 집계

        //정수 배열
        int[] arr = {1, 2, 3, 4, 5};

        //카운팅
        long count = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        //총합
        long sum = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        //평균
        double avg1 = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg1);

        //최대값
        int max = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        //최소값
        int min = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        //첫 번째 요소
        int first = Arrays.stream(arr)
                .filter(n -> n%2==0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);

        //Optional 클래스
        List<Integer> list6 = new ArrayList<>();

        //방법1
        OptionalDouble optional = list6.stream()
                .mapToInt(Integer :: intValue)
                .average();
        if(optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: 0.0");
        }

        //방법2
        double avg2 = list6.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2_평균: " + avg2);

        //방법3
        list6.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3_평균: " + a));

        //요소 커스텀 집게
        List<Student> studentList3 = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("감자바", 88)
        );
        //방법1
        int sum1 = studentList3.stream()
                .mapToInt(Student::getScore)
                .sum();

        //방법2
        int sum2 = studentList3.stream()
                .map(Student :: getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);

        //요소 수집
        //필터링한 요소 수집
        List<Student2> totalList = new ArrayList<>();
        totalList.add(new Student2("홍길동", "남", 92));
        totalList.add(new Student2("김수영", "여", 87));
        totalList.add(new Student2("감자바", "남", 95));
        totalList.add(new Student2("오해영", "여", 93));

        List<Student2> maleList = totalList.stream()
                .filter(s -> s.getSex().equals("남"))
                .toList();

        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println();

        //학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getName(),
                                s -> s.getScore()
                        )
                );

        System.out.println(map);

        //요소 그룹핑
        List<Student2> totalList2 = new ArrayList<>();
        totalList2.add(new Student2("홍길동", "남", 92));
        totalList2.add(new Student2("김수영", "여", 87));
        totalList2.add(new Student2("감자바", "남", 95));
        totalList2.add(new Student2("오해영", "여", 93));

        Map<String, List<Student2>> map1 = totalList2.stream()
                .collect(Collectors.groupingBy(s -> s.getSex())
                );

        List<Student2> maleList2 = map1.get("남");
        maleList2.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        List<Student2> femaleList = map1.get("여");
        femaleList.stream().forEach(s -> System.out.println(s.getName()));

        List<Student2> totalList3 = new ArrayList<>();
        totalList3.add(new Student2("홍길동", "남", 92));
        totalList3.add(new Student2("김수영", "여", 87));
        totalList3.add(new Student2("감자바", "남", 95));
        totalList3.add(new Student2("오해영", "여", 93));

        Map<String, Double> map2 = totalList3.stream()
                .collect(
                        Collectors.groupingBy(
                                s -> s.getSex(),
                                Collectors.averagingDouble(s -> s.getScore())
                        )
                );

        System.out.println(map2);

        //요소 병렬 처리
        Random random = new Random();

        List<Integer> scores = new ArrayList<>();
        for(int i = 0; i < 100000000; i++) {
            scores.add(random.nextInt(101));
        }

        double avg3 = 0.0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;

        Stream<Integer> stream4 = scores.stream();
        startTime = System.nanoTime();
        avg = stream4
                .mapToInt(i -> i.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");

        Stream<Integer> parallelStream4 = scores.parallelStream();
        startTime = System.nanoTime();
        avg = parallelStream4
                .mapToInt(i -> i.intValue())
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");

    }
}