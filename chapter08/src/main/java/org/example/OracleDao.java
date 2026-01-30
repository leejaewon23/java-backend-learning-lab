package org.example;

public class OracleDao implements DataAccessObject {
    @Override
    public void select() {
        System.out.println("Oracle DB 에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("Oracle DB에 삽입");
    }

    @Override
    public void update() {
        System.out.println("Oracle DB에 수정");
    }

    @Override
    public void delete() {
        System.out.println("Oracle DB에 삭제");
    }
}
