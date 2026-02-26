package org.example;

import java.util.*;

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



    }
}