package BoxingUnboxing;

public class Question {
    public static void question1(){
        Integer luong = 5000;
        float salary = luong.floatValue();
        System.out.printf("Lương của bạn là: %.2f%n", salary );
    }
    public static void question2(){
        String value = "1234567";
        int number = Integer.parseInt(value);
        System.out.println("number = " + number);
    }

    public static void question3(){
        Integer value = Integer.valueOf("1234567");
        int number = value.intValue();
        System.out.println("number = " + number);
    }

    public static void main(String[] args) {
        question1();
        question2();
        question3();
    }
}
