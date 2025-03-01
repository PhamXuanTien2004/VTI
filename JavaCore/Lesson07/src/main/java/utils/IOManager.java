package utils;

import java.io.*;

public class IOManager {
    private static final String FILE_NOT_EXISTS ="Error! File Not Exist.";
    private static final String OBJECT_NULL = "Error! Object is Null.";

    public static String readFile(String pathFile) throws Exception{
        if (!FileManager.isFileExists(pathFile)){
            throw new Exception(FILE_NOT_EXISTS) ;
        }
        try(FileInputStream fileInputStream = new FileInputStream(pathFile)){
            byte[] bytes = fileInputStream.readAllBytes();
            return new String(bytes);
        }
    }

    public static void writeFile(String pathFile,boolean isContinuing, String content) throws Exception {
        if (!FileManager.isFileExists(pathFile)){
            throw new Exception(FILE_NOT_EXISTS) ;
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(pathFile, isContinuing)){
            fileOutputStream.write(content.getBytes());
        }

    }

    public void writeObject(Object object, String path, String fileName) throws Exception {
        if (object == null) {
            throw new Exception(OBJECT_NULL);
        }
        if(!FileManager.isFileExists(path)){
            File folder = new File(path);
            folder.mkdir();
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(path + "\\" + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
            objectOutputStream.writeObject(object);
        }
    }

    public static Object readObject(String filePath)  {
        if(!FileManager.isFileExists(filePath)){
            throw new Exception(FILE_NOT_EXISTS);
        }
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
