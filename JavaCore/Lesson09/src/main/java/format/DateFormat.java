package format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) throws ParseException {
        //Date > String
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String dateStr = simpleDateFormat.format(date);
//        System.out.println(dateStr);
        //String > Date
        String dateStr = "21:09:56 2025-02-25 ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateStr);
        System.out.println(date);
    }

}
