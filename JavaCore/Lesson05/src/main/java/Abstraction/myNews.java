package Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class myNews {
    private static Scanner scanner = new Scanner(System.in);
    private static List <News> newsList= new ArrayList<> ();
    public static void main(String[] args) {
        while (true) {
            System.out.println("===My News===");
            System.out.println("1.Insert news");
            System.out.println("2.View list news");
            System.out.println("3.Average rate");
            System.out.println("4.Exit");
            System.out.println("My choise");
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise) {
                case 1:
                    innerNews();
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    printAverageRate();
                    break;
                case 4:
                    System.out.println("Bai Bai");
                    break;
                default:
                    break;
            }



        }
    }

    private static void printAverageRate() {
        System.out.println("Chuc nang hien thi tinh diem danh gia trung binh va hien thi danh sach news");
        for (News news: newsList){
            news.calculate();
            news.display();
        }
    }

    private static void viewListNews() {
        System.out.println("Chuc nang hien thi danh sach news");
        for (News news: newsList){
            news.display();
        }
    }

    private static void innerNews(){
        System.out.println("Chuc nang them news");
        System.out.println("Nhap title");
        String title = scanner.nextLine();
        System.out.println("Nhap PublishDate");
        String publishDate = scanner.nextLine();
        System.out.println("Nhap Author");
        String author = scanner.nextLine();
        System.out.println("Nhap Content");
        String content = scanner.nextLine();
        int[] rates = new int [3];
        for (int i=0;i<3;i++){
            System.out.println("Danh gia " + (i+1) +": ");
            int a = scanner.nextInt();
            scanner.nextLine();
            rates[i]= a;
        }

        News news1 = new News(title,publishDate, author, content, rates);
        newsList.add(news1);
        System.out.println("Them news thanh cong");
    }
}
