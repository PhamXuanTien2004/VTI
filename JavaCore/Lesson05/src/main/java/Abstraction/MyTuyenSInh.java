package Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTuyenSInh {
    private static Scanner scanner = new Scanner(System.in);
    private static List <TuyenSinh> newlist = new ArrayList<>();

    public static void main(String[] args) {
        while (true){
            System.out.println("=== Thông tin tuyển sinh ===");
            System.out.println("1. Thêm mới thí sinh.");
            System.out.println("2. Hiện thị thông tin của thí sinh và khối thi của thí sinh.");
            System.out.println("3. Tìm kiếm theo số báo danh.");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (choice){
                case 1:
                    them_thi_sinh();
                    break;
                case 2:
                    System.out.println("Baiiii");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn lại đeeeee");
                    break;
            }
        }
    }

    private static void them_thi_sinh() {
        System.out.println("Nhập Thông Tin Thí Sinh");
        System.out.println("Nhập số báo danh: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập khối thi: ");
        KhoiThi khoiThi = KhoiThi.valueOf(scanner.nextLine());
    }

}
