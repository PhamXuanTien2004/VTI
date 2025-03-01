package RandomNumber;

import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void inumber() {
        Random random = new Random();
        int a = random.nextInt();
        System.out.println("a = " + a);
    }

    public static void fnumber() {
        Random random = new Random();
        float a = random.nextFloat();
        System.out.println("a = " + a);
    }

    public static void student()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng học sinh: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] name = new String[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhập tên học sinh thứ " + (i+1) + " là:");
            name[i]=scanner.nextLine();
        }
        Random random = new Random();
        int a = random.nextInt(n);
        System.out.println("Tên học sinh thứ " + (a+1) + " là:" + name[a]);
    }

    public static void main(String[] args) {
        inumber();
        fnumber();
        student();
    }
}