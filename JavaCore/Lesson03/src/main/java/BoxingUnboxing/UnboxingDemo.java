package BoxingUnboxing;

public class UnboxingDemo {
    public static void main(String[] args) {
        Integer a =110;

        // thu cong
        int b= a.intValue();

        // auto unboxing
        int c= a;

        // chuyen string sang int
        int d = Integer.parseInt("123456");
    }
}
