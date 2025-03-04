package Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myNews {
    private static Scanner scanner = new Scanner(System.in);
    private static List<News> newsList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== My News ===");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    insertNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    printAverageRate();
                    break;
                case 4:
                    System.out.println("Bai Baiiiii");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập từ 1 đến 4.");
            }
        }
    }

    private static void insertNews() {
        System.out.println("Chức năng thêm news");
        System.out.print("Nhập Title: ");
        String title = scanner.nextLine();
        System.out.print("Nhập Publish Date: ");
        String publishDate = scanner.nextLine();
        System.out.print("Nhập Author: ");
        String author = scanner.nextLine();
        System.out.print("Nhập Content: ");
        String content = scanner.nextLine();

        int[] rates = new int[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                try {
                    System.out.print("Đánh giá " + (i + 1) + ": ");
                    rates[i] = Integer.parseInt(scanner.nextLine());
                    if (rates[i] < 1 || rates[i] > 5) {
                        System.out.println("Vui lòng nhập điểm từ 1 đến 5.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số hợp lệ!");
                }
            }
        }

        News news = new News(title, publishDate, author, content);
        news.setRates(rates);
        newsList.add(news);
        System.out.println("Thêm news thành công!");
    }

    private static void viewListNews() {
        if (newsList.isEmpty()) {
            System.out.println("Danh sách tin tức trống.");
            return;
        }
        System.out.println("Danh sách tin tức:");
        for (News news : newsList) {
            news.display();
        }
    }

    private static void printAverageRate() {
        if (newsList.isEmpty()) {
            System.out.println("Không có tin tức nào để hiển thị.");
            return;
        }
        System.out.println("Tính điểm đánh giá trung bình và hiển thị danh sách news:");
        for (News news : newsList) {
            news.calculate();
            news.display();
        }
    }
}
