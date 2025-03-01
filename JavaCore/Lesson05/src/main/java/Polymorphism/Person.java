package Polymorphism;

import java.util.Scanner;

public class Person {
    private String name;
    private Gender gender;
    private String date;
    private String address;
    public Scanner scanner = new Scanner(System.in);
    public Person() {}

    public Person(String name, Gender gender, String date, String address) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        System.out.println("Nhập tên: ");
        name = scanner.nextLine();

        while (true) {
            System.out.println("Nhập giới tính (1. Male, 2. Female, 3. Unknown): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gender = Gender.MALE;
                    break;
                case 2:
                    gender = Gender.FEMALE;
                    break;
                case 3:
                    gender = Gender.UNKNOWN;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    continue;
            }
            break;
        }

        System.out.println("Nhập ngày sinh: ");
        date = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = scanner.nextLine();
    }

    public void showInfor(){

    }

}
