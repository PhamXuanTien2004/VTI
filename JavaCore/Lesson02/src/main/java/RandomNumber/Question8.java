package RandomNumber;

import java.util.Scanner;

public class Question8 {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int age;
    private String position;

    public Question8() {
    }

    public Question8(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void program() {
        while (true) {
            System.out.println("\nMời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1: Nhập thông tin tài khoản");
            System.out.println("2: In ra 'hi'");
            System.out.println("0: Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");

            int n = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (n) {
                case 1:
                    account();
                    break;
                case 2:
                    department();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    return; // Thoát khỏi vòng lặp
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    private void department() {
    }

    private void account() {
        int n;
        System.out.print("Tên: ");
        name = scanner.nextLine();
        System.out.print("Tuổi: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        System.out.println("Chọn chức vụ:");
        System.out.println("1: Dev\n2: Test\n3: Scrum Master\n4: PM");

        do {
            System.out.print("Nhập chức vụ của bạn: ");
            n = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (n) {
                case 1:
                    position = "DEV";
                    break;
                case 2:
                    position = "TEST";
                    break;
                case 3:
                    position = "Scrum Master";
                    break;
                case 4:
                    position = "PM";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        } while (n < 1 || n > 4);

        System.out.println("\nThông tin đã nhập:");
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Chức vụ: " + position);
    }

    public static void main(String[] args) {
        Question8 q = new Question8();
        q.program();
    }
}
