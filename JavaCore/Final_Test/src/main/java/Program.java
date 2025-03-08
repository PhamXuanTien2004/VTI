import controller.UserController;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      UserController userController = new UserController();

//        User user = userController.getUserById(3);
//        System.out.println(user);
//
//        userController.deleteUserById(4);
        System.out.println("=====Test JavaCore=====");
        while (true){
            System.out.println("1. Hiển thị ra danh sách tất cả User");
            System.out.println("2. Tìm và in thông tin User bằng id do bạn nhập vào");
            System.out.println("3. Xóa thông tin User bằng id do bạn nhập vào");
            System.out.println("4. Login vào dữ liệu");
            System.out.println("5. Thêm thông tin User (Chỉ dành cho Admin)");
            System.out.println("0. Thoát ra khỏi chuơng trình");

            System.out.println("==============================================================================");
            System.out.println("                Hãy nhập lựa chọn của bạn");
            int my_choose  = scanner.nextInt();
            scanner.nextLine();
            switch (my_choose){
                case 1:
                    List<User> users = userController.getAllUser();
                    users.forEach(user -> System.out.println(user));
                    break;
                case 2:
                    System.out.println("Nhập vào id của User mà bạn muốn biết thông tin.");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();
                    User user = userController.getUserById(id2);
                    System.out.println(user);
                    break;
                case 3:
                    System.out.println("Nhập vào id của User mà bạn muốn xóa thông tin.");
                    int id3 = scanner.nextInt();
                    scanner.nextLine();
                    userController.deleteUserById(id3);
                    break;
                case 4:
                    login();
                    break;
                case 0:
                    System.out.println("Baiiii");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn lại đeeeeeeeeeeee");
                    my_choose  = scanner.nextInt();
                    scanner.nextLine();
                    break;

            }
        }
    }

    public static void login(){
            System.out.println("=====Login=====");
            System.out.println("Nhập email");
            String email = check_email();
            System.out.println("Nhập password");
            String password = check_password();
            System.out.println("Bạn đã login thành công!!!");
    }

    private static String check_password() {
        while (true){
            String password = scanner.nextLine();
            if (password == null || password.length()<6 || password.length()>12 || containsUpperCase(password)== false){
                System.out.println("Hãy nhập lại password");
            } else  {
                return password;
            }
        }
    }

    public static boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static String check_email(){
        while (true){
            String email = scanner.nextLine();
            if (email == null || ! email.contains("@")){
                System.out.println("Hãy nhập lại email");
            } else {
                return email;
            }
        }
    }



}
