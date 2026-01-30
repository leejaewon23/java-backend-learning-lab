package org.example;

public interface DataAccessObject {
    void select();
    void insert();
    void update();
    void delete();


    static void dbWork(DataAccessObject dao) {
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }
}

