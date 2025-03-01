package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
//        Nhap
//        FileOutputStream fileOutputStream = new FileOutputStream("demo1.txt");
//        byte[] bytes = "Day la noi dung".getBytes();
//        fileOutputStream.write(bytes);
//        fileOutputStream.close();

        try(FileOutputStream fileOutputStream = new FileOutputStream("demo1.txt"))
        {
            byte[] bytes = "Day la noi dung".getBytes();
            fileOutputStream.write(bytes);
        }
        catch ()
//        In
//        FileInputStream fileInputStream = new FileInputStream("demo1.txt");
//        try(fileInputStream){
//            byte[] bytes = fileInputStream.readAllBytes();
//            String content = new String(bytes);
//            System.out.println(content);
//        }

    }
}
