package utils;

import java.io.File;

public class FileManager {
    public static boolean isFileExists(String path) throws Exception {
        File file = new File(path);
        if(file.createNewFile()){
            return false;
        }else {return true;}
    }
}
