import controller.UserController;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserController userController = new UserController();

        System.out.println("=====Final JavaCore=====");
        while (true){
            System.out.println("1. Hiện thị ra tất cả các employee trong ProjectId");
            System.out.println("2. Hiện thị tất cả các Manager của ProjectId");
            System.out.println("3. Login vào dữ liệu");
            System.out.println("0. Thoát ra khỏi chuơng trình");

            System.out.println("==============================================================================");
            System.out.println("                Hãy nhập lựa chọn của bạn");
            int my_choose  = scanner.nextInt();
            scanner.nextLine();
            switch (my_choose){
                case 1:
                    System.out.println("Nhập vào ProjectId.");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    User user = userController.getEmployeeByProjectId(id);
                    System.out.println(user);
                    break;
                case 2:
                    System.out.println("Các Manager của từng Project là:");
                    List<User> users = userController.getManager();
                    users.forEach(user1 -> System.out.println(user1));
                    break;
                case 3:
                    System.out.println("Nhập email:");
                    String email = check_email();
                    System.out.println("Nhập password:");
                    String password = check_password();

                    User user2 = userController.loginManager(email, password);
                    System.out.println("Đăng nhập thành công: " );

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
    private static String check_password() {
        while (true){
            String password = scanner.nextLine();
            if (password == null || password.length()<6 || password.length()>12 ){
                System.out.println("Hãy nhập lại password");
            } else  {
                return password;
            }
        }
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
