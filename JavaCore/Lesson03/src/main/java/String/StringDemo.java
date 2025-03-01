package String;

public class StringDemo {
    public static void main(String[] args) {
        //Primite
        // neu chua co se tao dia chi moi
        String s1 = "java core";
        String s2 = "java core";

        //non primitive
        // luon luon tao dia chi moi
        String s3 = new String("java core");
        String s4 = new String("java core");

        // ==: so sanh dia chi
        System.out.println(s1==s2);
        System.out.println(s3==s2);
        System.out.println(s3==s4);

        // equals: so sanh noi dung
        System.out.println(s1.equals(s2));
        System.out.println(s3.equals(s2));
        System.out.println(s3.equals(s4));
    }
}
