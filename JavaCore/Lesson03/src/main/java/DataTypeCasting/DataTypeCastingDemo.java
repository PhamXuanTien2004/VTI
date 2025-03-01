package DataTypeCasting;

public class DataTypeCastingDemo {
    public static void main(String[] args) {
        // Windening
        // byte -> short -> int -> long -> float ->double
        int a= 100;
        long b =(long) a;
        System.out.println("b = " + b);
        // Narrowing
        //double -> float -> long -> int -> short -> byte
        long c=800000000000l;
        System.out.println("c = " + c);
        int d = (int) c;
        System.out.println("d = " + d);
    }
}
