package frontend;

import entity.MyMath;

public class Exercise2 {
    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        float a = myMath.sum(5);
        System.out.println("a = " + a);
    }
}
