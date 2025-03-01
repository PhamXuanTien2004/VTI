package DefaultValue;

import java.time.LocalDate;
import java.util.Scanner;

public class Question {
    public void account(){
        String email;
        String userName;
        String fullName;
        LocalDate createDateNow = LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập email = " );
        email = scanner.nextLine();
        System.out.println("Nhập username = " );
        userName = scanner.nextLine();
        System.out.println("Nhập full name = " );
        fullName = scanner.nextLine();

    }

}
