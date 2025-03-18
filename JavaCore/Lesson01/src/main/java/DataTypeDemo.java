import java.time.LocalDate;

public class DataTypeDemo {
    public  static  void main(String[] args){
        // kiểu số nguyên
        // byte, int, long, short
        int age =18;
        System.out.println("Tuoi la : " +age);
        System.out.println("age = " + age);

        // kiểu số thực
        // float, double
        // giá trị mặc định: 0.0
        float money = 123.456f;

        //Kiểu boolean
        // true, false
        // gtri mặc định: flase
        boolean isLoading = true;
        System.out.println("isLoading = " + isLoading);

        // Kiểu char
        // gtri mă định: \u0000
        char c = 'T';
        System.out.println("c = " + c);

        // kiểu string
        String s = "Nguyễn Văn Khoa";
        System.out.println("s = " + s);

        // kểu date
        // localdate, localTime, localDateTime
        LocalDate toDay = LocalDate.now();
        System.out.println("toDay = " + toDay);
        LocalDate date = LocalDate.of(2005, 9, 3);
        System.out.println("date = " + date);

        // kiểu enum
//        Gender gender = Gender.FEMALE;
//        System.out.println("gender = " + gender);

        // Kiểu array
        int[] numbers = {2, 4, 6, 8};
        String[] fruits = new String[]{"Cam", "Táo", "Ổi"};
        // Chỉ số bắt đầu từ 0
        System.out.println("numbers[0] = " + numbers[0]);
        int lastIndex = numbers.length - 1;
        System.out.println("numbers[" + lastIndex + "] = " + numbers[lastIndex]);
        System.out.println("numbers.length = " + numbers.length);
    }
}
