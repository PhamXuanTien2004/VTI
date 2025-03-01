package entity;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    public static String collect = "Đại học Bách Khoa";
    public static int money_group;
    private static Scanner scanner = new Scanner(System.in);

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student( ){
        System.out.println("Nhập tên sinh viên:");
        this.name= scanner.nextLine();
        money_group +=100;
        this.id = ++id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + (id) +
                ", name='" + name + '\'' +
                ", college='" + collect+
                '}';
    }
}
