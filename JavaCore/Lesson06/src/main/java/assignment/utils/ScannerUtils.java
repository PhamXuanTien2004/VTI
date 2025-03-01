package assignment.utils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);
    public static int intAge(){
        while (true){
            System.out.println("Nhap vao tuoi: ");
            String ageStr = scanner.nextLine();

            try{
                int age = Integer.parseInt(ageStr);
                if(age>=0)
                {
                    return age;
                }
                System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
            } catch (NumberFormatException e){

                System.out.println("wrong inputing! Please input an age as int, input again.");

            }
        }
    }
}
