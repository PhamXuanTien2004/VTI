package AssignmentExtra.String;

import java.util.Scanner;

public class string {
    private Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    void question1() {
        System.out.print("Nhập tên: ");
        string name = scanner.nextLine();
        System.out.println("Tên vừa nhập là: " + name);
    }

    public static void main(string[] args) {
        string obj = new string();
        obj.question1();
    }
}

