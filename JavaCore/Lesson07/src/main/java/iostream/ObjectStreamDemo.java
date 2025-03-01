package iostream;

public class ObjectStreamDemo {

    public void writeObject(Object object, String path, String fileName){
        if (!FileUltis.isFileExists(path)) {
            throw new Exception(FILE_NOT_EXIST);
        }
        System.out.print("File name:");
        fileName = ScannerUltis.inputString();
        path = path + "\\" + fileName;
        FileOutputStream out = new FileOutputStream(path);
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(object);
        out.close();
        objectOut.close();
        System.out.println(WRITE_FILE_SUCCESS);

    }
}
