package AssignmentExtra.String;

import java.util.Scanner;

public class String_Extra {
    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    void question1() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Tên vừa nhập là: " + name);
        System.out.println("Tên viết hoa là: " + name.toUpperCase());
    }

    void question2() {
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        int count = 0;

        System.out.println("Số lần xuất hiện của ký tự 'a' là: ");
        for (int i=0;i<str.length();i++)
        {
            if (str.charAt(i)== 'a'){
                System.out.print((i+1)+ " ");
                count++;
            }
        }
        System.out.println("\nSố lần ký tự 'a' xuất hiện trong chuỗi là:" + count);
    }

    void question3(){
        System.out.println("Nhập xâu ký tự");
        String s = scanner.nextLine();

        String x;
        do{
            System.out.println("Ký tự cần thay thế");
            x = scanner.nextLine();
        }while (x.length() !=1);

        System.out.println("Ký tự dùng để thay thế");
        String y = scanner.nextLine();

        s = s.replace(x.charAt(0), y.charAt(0));

        System.out.println("Xâu ký tự sau khi thay đổi là:" +s);
    }

    void question6() {
        System.out.println("Nhập xâu ký tự:");
        String s = "Java – Nơi trí tưởng tượng bay xa"; // Loại bỏ khoảng trắng dư thừa ở đầu & cuối chuỗi

        String[] words = s.split(" ");; // Tách từ bằng khoảng trắng (bao gồm nhiều dấu cách liên tiếp)

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            System.out.println(words[i]);
        }

    }

    public static void main(String[] args) {
        String_Extra obj = new String_Extra();
        obj.question6();
    }
}
