package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //ArrayList 컬렉션 생성
        List<Board> list = new ArrayList<>();

        //객체 추가
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        //저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();

        //특정 인덱스의 객체 가져오기
        Board board = list.get(2);
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
        System.out.println();

        //모든 객체를 하나씩 가져오기
        for(int i=0; i< list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

        //객체 삭제
        list.remove(2);
        list.remove(2);

        //향상된 for 문으로 모든 객체를 하나씩 가져오기
        for(Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }

        //Vector 컬렉션 생성
        List<Board> list1 = new Vector<>();

        //작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                //객체 1000개 추가
                for(int i=1; i<= 1000; i++) {
                    list1.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
                }
            }
        };

        //작업 스레드 객체 생성
        Thread threadB = new Thread() {
            @Override
            public void run() {
                //객체 1000개 추가
                for(int i=1001; i<= 2000; i++) {
                    list1.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
                }
            }
        };

        //작업 스레드 실행
        threadA.start();
        threadB.start();

        //작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
        }

        //저장된 총 객체 수 얻기
        int size1 = list1.size();
        System.out.println("총 객체 수: " + size1);
        System.out.println();

        //ArrayList 컬렉션 객체 생성
        List<String> list2 = new ArrayList<String>();

        //LinkedList 컬렉션 객체 생성
        List<String> list3 = new LinkedList<String>();

        //시작 시간과 끝 시간을 저장할 변수 선언
        long startTime;
        long endTime;

        //ArrayList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for(int i=0; i<10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime-startTime) );

        //LinkedList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for(int i=0; i<10000; i++) {
            list3.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ",  (endTime-startTime) );

        //HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

        //객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        //저장된 객체 수 출력
        int size2 = set.size();
        System.out.println("총 객체 수: " + size2);

        //HashSet 컬렉션 생성
        Set<Member> set1 = new HashSet<Member>();

        //Member 객체 저장
        set1.add(new Member("홍길동", 30));

        //저장된 객체 수 출력
        System.out.println("총 객체 수: " + set1.size());

        //HashSet 컬렉션 생성
        Set<String> set2 = new HashSet<String>();

        //객체 추가
        set2.add("Java");
        set2.add("JDBC");
        set2.add("JSP");
        set2.add("Spring");

        //객체를 하나씩 가져와서 처리
        Iterator<String> iterator = set2.iterator();
        while(iterator.hasNext()) {
            //객체를 하나 가져오기
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("JSP")) {
                //가져온 객체를 컬렉션에서 제거
                iterator.remove();
            }
        }
        System.out.println();

        //객체 제거
        set2.remove("JDBC");

        //객체를 하나씩 가져와서 처리
        for(String element : set2) {
            System.out.println(element);
        }

        //Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        //객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        //키로 값 얻기
        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        //키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + ": " + v);
        }
        System.out.println();

        //엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
        System.out.println();

        //키로 엔트리 삭제
        map.remove(key);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        //Hashtable 컬렉션 생성
        Map<String, Integer> map1 = new Hashtable<>();

        //작업 스레드 생성
        Thread threadC = new Thread() {
            @Override
            public void run() {
                for(int i=1; i<= 1000; i++) {
                    map1.put(String.valueOf(i), i);
                }
            }
        };

        //작업 스레드 객체 생성
        Thread threadD = new Thread() {
            @Override
            public void run() {
                for(int i=1001; i<= 2000; i++) {
                    map1.put(String.valueOf(i), i);
                }
            }
        };

        //작업 스레드 실행
        threadC.start();
        threadD.start();

        //작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
        try {
            threadC.join();
            threadD.join();
        } catch (Exception e) {
        }

        //저장된 총 엔트리 수 얻기
        int size3 = map1.size();
        System.out.println("총 엔트리 수: " + size3);
        System.out.println();


//        Properties properties = new Properties();
//
//        // 1. try-with-resources 문법을 사용하여 스트림을 자동으로 닫아줍니다.
//        // 2. 경로 앞에 "/"를 붙여서 프로젝트 루트(resources)부터 찾습니다.
//        try (InputStream is = Main.class.getResourceAsStream("database.properties")) {
//
//            if (is == null) {
//                System.out.println("오류: database.properties 파일을 찾을 수 없습니다.");
//                return; // 파일이 없으면 아래 로직을 수행하지 않음
//            }
//
//            properties.load(is);
//
//            // 주어진 키에 대한 값 읽기
//            String driver = properties.getProperty("driver");
//            String url = properties.getProperty("url");
//            String username = properties.getProperty("username");
//            String password = properties.getProperty("password");
//            String admin = properties.getProperty("admin");
//
//            // 값 출력
//            System.out.println("driver: " + driver);
//            System.out.println("url: " + url);
//            System.out.println("username: " + username);
//            System.out.println("password: " + password);
//            System.out.println("admin: " + admin);

//        } catch (IOException e) {
//            System.out.println("파일 로드 중 오류 발생: " + e.getMessage());
//        }

        //TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>();

        //Integer 객체 저장
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        //정렬된 Integer 객체를 하나씩 가져오기
        for(Integer s : scores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        //특정 Integer 객체를 가져오기
        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());
        System.out.println("95점 아래 점수: " + scores.lower(95));
        System.out.println("95점 위의 점수: " + scores.higher(95));
        System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
        System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

        //내림차순으로 정렬하기
        NavigableSet<Integer> rangeSet = scores.tailSet(80,  true);
        for(Integer s : rangeSet) {
            System.out.print(s + " ");
        }
        System.out.println();

        //범위 검색
        rangeSet = scores.subSet(80, true, 90, false);
        for(Integer s : rangeSet) {
            System.out.print(s + " ");
        }

        //TreeMap 컬렉션 생성
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //엔트리 저장
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        //정렬된 엔트리를 하나씩 가져오기
        Set<Map.Entry<String, Integer>> entrySet1 = treeMap.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();

        //특정 키에 대한 값 가져오기
        Map.Entry<String, Integer> entry1 = null;
        entry1 = treeMap.firstEntry();
        System.out.println("제일 앞 단어: " + entry1.getKey() + "-" +  entry1.getValue());
        entry1 = treeMap.lastEntry();
        System.out.println("제일 뒤 단어: " + entry1.getKey() + "-" +  entry1.getValue());
        entry1 = treeMap.lowerEntry("ever");
        System.out.println("ever 앞 단어: " + entry1.getKey() + "-" +  entry1.getValue() + "\n");

        //내림차순으로 정렬하기
        NavigableMap<String,Integer> descendingMap = treeMap.descendingMap();
        Set<Map.Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        for(Map.Entry<String,Integer> e : descendingEntrySet) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
        System.out.println();

        //범위 검색
        System.out.println("[c~h 사이의 단어 검색]");
        NavigableMap<String,Integer> rangeMap = treeMap.subMap("c", true, "h", false);
        for(Map.Entry<String, Integer> e : rangeMap.entrySet()) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }

        //TreeSet 컬렉션 생성
        TreeSet<Person> treeSet = new TreeSet<Person>();

        //객체 저장
        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("김자바", 25));
        treeSet.add(new Person("박지원", 31));

        //객체를 하나씩 가져오기
        for(Person person : treeSet) {
            System.out.println(person.name + ":" + person.age);
        }

        //비교자를 제공한 TreeSet 컬렉션 생성
        TreeSet<Fruit> treeSet1 = new TreeSet<Fruit>(new FruitComparator());

        //객체 저장
        treeSet1.add(new Fruit("포도", 3000));
        treeSet1.add(new Fruit("수박", 10000));
        treeSet1.add(new Fruit("딸기", 6000));

        //객체를 하나씩 가져오기
        for(Fruit fruit : treeSet1) {
            System.out.println(fruit.name + ":" + fruit.price);
        }

        //Stack 컬렉션 생성
        Stack<Coin> coinBox = new Stack<Coin>();

        //동전 넣기
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        //동전을 하나씩 꺼내기
        while(!coinBox.isEmpty()) {
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
        }

        //Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();

        //메세지 넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        //메세지 하나씩 꺼내어 처리
        while(!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            switch(message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;

            }
        }

        //Map 컬렉션 생성
        Map<Integer, String> map2 = Collections.synchronizedMap(new HashMap<>());

        //작업 스레드 객체 생성
        Thread threadE = new Thread() {
            @Override
            public void run() {
                for(int i = 1; i <= 1000; i++) {
                    map2.put(i, "내용" + i);
                }
            }
        };

        Thread threadF = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    map2.put(i, "내용" + i);
                }
            }
        };

        //작업 스레드 실행
        threadE.start();
        threadF.start();

        try{
            threadE.join();
            threadF.join();
        } catch (Exception e) {
        }

        int size4 = map2.size();
        System.out.println("총 객체 수: " + size4);
        System.out.println();

        //List 불변 컬렉션 생성
        List<String> immutablelist1 = List.of("A", "B", "C");

        //Set 불변 컬렉션 생성
        Set<String> immutableSet1 = Set.of("A", "B", "C");

        //Map 불변 컬렉션 생성
        Map<Integer, String> immutableMap1 = Map.of(
                1, "A",
                2, "B",
                3, "C"
        );

        //List 컬렉션을 불변 컬렉션으로 복사
        List<String> list4 = new ArrayList<>();
        list4.add("A");
        list4.add("B");
        list4.add("C");
        List<String> immutablelist2 = List.copyOf(list4);

        //Set 컬렉션을 불변 컬렉션으로 복사
        Set<String> set3 = new HashSet<>();
        set3.add("A");
        set3.add("B");
        set3.add("C");
        Set<String> immutableSet2 = Set.copyOf(set3);

        //Map 컬렉션을 불변 컬렉션으로 복사
        Map<Integer, String> map3 = new HashMap<>();
        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "C");
        Map<Integer, String> immutableMap2 = Map.copyOf(map3);

        //배열로부터 List 불변 컬렉션 생성
        String[] arr =  {"A", "B", "C"};
        List<String> immutablelist3 = Arrays.asList(arr);

        //확인문제 7번
        BoardDao dao = new BoardDao();
        List<Board1> list5 = dao.getBoardList();

        list5.add(new Board1("제목1", "내용1"));
        list5.add(new Board1("제목2", "내용2"));
        list5.add(new Board1("제목3", "내용3"));
        for(Board1 board1 : list5) {
            System.out.println(board1.getTitle() + "-" + board1.getContent());
        }

        //확인문제 8번
        Set<Student> set4 = new HashSet<Student>();

        set4.add(new Student(1, "홍길동"));
        set4.add(new Student(2, "신용권"));
        set4.add(new Student(1, "조민우"));

        System.out.println("저장된 객체 수: " + set4.size());
        for(Student s : set4) {
            System.out.println(s.studentNum + "-" + s.name);
        }

        //확인문제 9번
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("blue", 96);
        map4.put("hong", 86);
        map4.put("white", 92);

        String name = null;
        int maxScore = Collections.max(map4.values());
        int totalScore = 0;

        // Map.Entry를 사용하여 이름(key)과 점수(totalScore 합산) 구하기
        for (Map.Entry<String, Integer> entry : map4.entrySet()) {
            totalScore += entry.getValue(); // 합계 누적

            if (entry.getValue() == maxScore) { // 점수가 최고 점수와 같다면
                name = entry.getKey(); // 해당 아이디 저장
            }
        }

        int avgScore = totalScore / map4.size(); // 평균 계산
        System.out.println("평균 점수: " + avgScore);
        System.out.println("최고 점수: " + maxScore);
        System.out.println("최고 점수를 받은 아이디: " + name);
        System.out.println("---------------------");

        //확인문제 10번
        TreeSet<Student2> treeSet2 = new TreeSet<Student2>();
        treeSet2.add(new Student2("blue", 96));
        treeSet2.add(new Student2("hong", 86));
        treeSet2.add(new Student2("white", 92));

        Student2 student2 = treeSet2.last();
        System.out.println("최고 점수: " + student2.score);
        System.out.println("최고 점수를 받은 아이디: " + student2.id);












    }

}