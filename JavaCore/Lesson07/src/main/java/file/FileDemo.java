package file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\VTI\\JavaCore\\Lesson07\\demo1.txt");
//        if(file.createNewFile()){
//            System.out.println("Created");
//        }else {
//            System.out.println("File chưa tạo được");
//        }
        if(file.exists()){
            System.out.println("File/folder exists");
        } else{
            System.out.println("File/folder not exists");
        }

        if(file.isDirectory()){
            System.out.println("isDirectory");
            String[] subFileNames = file.list();
            for (String subFileName: subFileNames){
                System.out.println(subFileName);
            }
        }

    }

}
