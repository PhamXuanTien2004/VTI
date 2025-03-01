package String;

import java.util.Scanner;

public class Question {
    public static Scanner scanner = new Scanner(System.in);
    public static void question1(){
//        Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó
//                (các từ có thể cách nhau bằng nhiều khoảng trắng );
        String str = "Vũ Thùy Dương   ";
        String[] words = str.split(" ");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        System.out.println("Số từ: " + count);
    }

    public static void question2(){
//        Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
        String s1 = "Vũ Thùy ";
        String s2= "Dương";
        System.out.println("(s1+s2) = " + (s1 + s2));
    }

    public static void question3(){
//        Viết chương trình để người dùng nhập vào tên và kiểm tra,
//        nếu tên chữ viết hoa chữ cái đầu thì viết hoa lên
        String s2= "dương";
        String f = s2.substring(0,1).toUpperCase();
        String s = s2.substring(1).toLowerCase();
        System.out.println("Viết hoa chữ cái đầu = " + (f+s));
    }

    public static void question4(){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        for(int i=0;i<name.length();i++)
        {
            System.out.println("Ký tự thứ " + (i+1) +" là: "+ name.charAt(i));
        }
    }

    public static void question5(){
        System.out.println("Nhập họ: ");
        String firstName = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String lastName = scanner.nextLine();
        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        System.out.println("Họ và tên là: " + (firstName +" "+  lastName));
    }

    public static void question6(){
        System.out.println("Nhập họ và tên: ");
        String name = scanner.nextLine();

        String[] words = name.split(" ");

        int n = words.length;
        String firstName = words[0];
        String lastName="";
        for(int i=1;i< words.length-1;i++){
            lastName+=words[i] + " ";
        }
        System.out.println("Họ = " + firstName);
        System.out.println("Tên đệm = " + lastName);
        System.out.println("Tên = " +  words[n-1]);
    }

    public static void question7(){
        System.out.println("Nhập họ và tên: ");
        String name = scanner.nextLine().trim();
        String[] words = name.split(" ");
        for(int i=0;i< words.length;i++)
        {
            String f = words[i].substring(0,1).toUpperCase();
            String s = words[i].substring(1).toLowerCase();
            System.out.print( (f + s) + " ");
        }
    }

    public static void question10(){
        System.out.println("Nhập chuỗi 1: ");
        String s1 = scanner.nextLine();
        System.out.println("Nhập chuỗi 2: ");
        String s2 = scanner.nextLine();

        String test="";

        for(int i=0;i<s1.length();i++){
            test = s1.charAt(i) + test;
        }

        if(test.equals(s2)){
            System.out.println(s1+" và "+ s2+ " là 2 chuỗi đảo ngược nhau.");
        }else {
            System.out.println(s1+" và "+ s2+ " không phải là 2 chuỗi đảo ngược nhau.");
        }
    }

    public static void question11(){
        System.out.println("Nhập chuỗi : ");
        String str = scanner.nextLine();

        System.out.println("Nhập ký tự : ");
        char check = scanner.next().charAt(0); // Chuyển String thành char
        int count=0;
        for(int i=0;i<str.length();i++){
            if(check==str.charAt(i)){
                count++;
                }
        }
        System.out.println("Số lần xuất hiện của ký tự '" + check + "' là: " + count);
    }

    public static void question14(){
        System.out.println("Nhập chuỗi : ");
        String str = scanner.nextLine();

        System.out.println("Nhập ký tự muốn thay thế : ");
        char check = scanner.next().charAt(0);
        System.out.println("Nhập ký tự được thay thế : ");
        char change = scanner.next().charAt(0);

        // Dùng StringBuilder để tạo chuỗi mới có thể sửa đổi
        StringBuilder newStr = new StringBuilder(str);

        for (int i = 0; i < newStr.length(); i++) {
            if (newStr.charAt(i) == check) {
                newStr.setCharAt(i, change); // Thay thế ký tự
            }
        }

        System.out.println("Chuỗi sau khi thay đổi: " + newStr.toString());

    }

    public static void main(String[] args) {
//        question1();
//        question2();
//        question3();
//        question4();
//        question5();
        question14();
    }
}
