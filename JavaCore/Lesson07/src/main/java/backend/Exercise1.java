package backend;

import entity.Student;

import java.util.Scanner;

public class Exercise1 {
    public void question1(){
        System.out.println("So thong tin sv can nhap la: ");
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        scanner.nextLine();
        Student[] studentArray = new Student[n];
        System.out.println("khởi tạo "+ n+" sinh viên");
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên " + (i + 1) + ":");
            Student st = new Student();
            studentArray[i] = st;
        }
        System.out.println("Thông tin các sinh viên vừa nhập: ");
        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }

        System.out.println("Chuyển các sinh viên sang Đại học công nghệ: ");
        Student.collect = "Đại học Công nghệ ";
        System.out.println("Thông tin sinh viên sau khi chuyển ");
        for (int i = 0; i < studentArray.length; i++) {
            System.out.println(studentArray[i]);
        }

        System.out.println("Số tiền mà sv đóng là: "+Student.money_group);
        System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan");
        Student.money_group-=50;
        System.out.println("Số tiền hiện tại là: "+Student.money_group);
        System.out.println("Student thứ 2 lấy 20k đi mua bánh mì");
        Student.money_group-=20;
        System.out.println("Số tiền hiện tại là: "+Student.money_group);
        System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm");
        Student.money_group-=150;
        System.out.println("Số tiền hiện tại là: "+Student.money_group);
        System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k");
        Student.money_group+=n*50;
        System.out.println("Số tiền hiện tại là: "+Student.money_group);

    }


}
