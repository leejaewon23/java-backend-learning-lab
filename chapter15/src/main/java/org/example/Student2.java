package org.example;

public class Student2 implements Comparable<Student2> {
    public String id;
    public int score;

    public Student2 (String id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student2 student2) {
        if(score<student2.score) return -1;
        else if(score>student2.score) return 1;
        else return 0;
    }


}
