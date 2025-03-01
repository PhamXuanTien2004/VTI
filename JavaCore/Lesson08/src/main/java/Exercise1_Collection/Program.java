package Exercise1_Collection;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Nhap so phan tu cua mang: ");
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        scanner.nextLine();
        List<Student> students= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ten sinh vien thu " + (i + 1) + ": ");
            String name = scanner.nextLine();
            students.add(new Student(name)); // Thêm sinh viên vào danh sách
        }

        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            System.out.println(student);
        }

//        System.out.println("Tong so phan tu cua Student = " + students.size());
//        System.out.println("Phần tử thứ 4 của students = " + students.get(3));
//        System.out.println("students.getLast() = " + students.getLast());
//        System.out.println("students.getFirst() = " + students.getFirst());
//
//        students.add(0, new Student("Tiến"));
//        System.out.println("students.getFirst() = " + students.getFirst());
//        students.add(students.size(),new Student("Tiến"));
//        System.out.println("students.getLast() = " + students.getLast());

//        System.out.println("Đảo ngược vị trị của Students");
//        List<Student> revertStudents = new ArrayList<>();
        //Cách 1
//        for(int i= students.size()-1;i>=0;i--)
//        {
//            revertStudents.add(students.get(i));
//        }
//        System.out.println(revertStudents);
        //Cách 2
//        Collections.reverse(students);
//        System.out.println(students);
//g) Tạo 1 method tìm kiếm student theo id
//        System.out.println("Nhập ID cần tìm: ");
//        int checkID = scanner.nextInt();
//        scanner.nextLine();
//        findID(students, checkID);

//h)      Tạo 1 method tìm kiếm student theo name
//        System.out.println("Nhập NAME cần tìm: ");
//        String checkName = scanner.nextLine();
//        findName(students, checkName);

//        Tạo 1 method để in ra các student có trùng tên
//        trungName(students);
//        j) Xóa name của student có id = 2;
        deleteByID(students);
//        k) Delete student có id = 5;
        deleteStudentByName(students);
//        l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies








    }

    private static void deleteStudentByName(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên muốn xóa tên");
        int check = scanner.nextInt();
        scanner.nextLine();
        for (Student student : students) {
            if (student.getId() == check) {
                student.setName(null) ;
                System.out.println(student);
            }
        }
    }

    private static void deleteByID(List<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID muốn xóa tên");
        int check = scanner.nextInt();
        scanner.nextLine();
        for (Student student : students) {
            if (student.getId() == check) {
                student.setName(null) ;
                System.out.println(student);
            }
        }
    }

    private static void trungName(List<Student> students) {
        List<String> duplicatedNames = new ArrayList<>();
        List<Student> result = new ArrayList<>();

        // Tìm các tên bị trùng
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getName().equals(students.get(j).getName())) {
                    duplicatedNames.add(students.get(i).getName());
                }
            }
        }

        // Lọc danh sách sinh viên có tên trùng
        for (Student student : students) {
            if (duplicatedNames.contains(student.getName())) {
                result.add(student);
            }
        }

        // Hiển thị sinh viên có tên trùng
        for (String name : duplicatedNames) {
            System.out.println("Danh sách sinh viên có tên '" + name + "':");
            findName(result, name);
        }
    }




    private static void findName(List<Student> students, String check) {
        for (Student student : students) {
            if (student.getName().equals(check) ) {
                System.out.println("Student có name là '"+ check + "' :" + student);
            }
        }
    }

    private static void findID(List<Student> students , int check) {
        for (Student student : students) {
            if (student.getId() == check) {
                System.out.println("Student có id '"+ check + "' là:" + student);
            }
        }
    }
}
