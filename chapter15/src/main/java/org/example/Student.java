package org.example;

public class Student {
    public int studentNum;
    public String name;

    public Student(int studentNum, String name) {
        this.studentNum = studentNum;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return studentNum;
    }

    // 학번이 같으면 true를 반환하도록 수정
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            // 학번(studentNum)이 같으면 동일한 객체로 판정
            return student.studentNum == this.studentNum;
        }
        // Student 타입이 아니거나 null이면 무조건 false
        return false;
    }
}
