package org.kamaljeet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int rollNo;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollno(int rollno) {
        this.rollNo = rollno;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno=" + rollNo +
                ", age=" + age +
                '}';
    }
}
