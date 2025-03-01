package assignment;

import assignment.utils.ScannerUtils;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
//        try{
//            float result = divide(7,0);
//
//            System.out.println(result);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }finally {
//            System.out.println("divide completed!");
//        }
//        System.out.println("End");
        int age = ScannerUtils.intAge();
        System.out.println(age);
    }

    private static float divide(int i, int i1) {
        return i/i1;
    }
}