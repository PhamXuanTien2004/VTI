package frontend;

import utils.IOManager;



public class Program {
    public static void main(String[] args) {
        String path = "D:\\VTI\\JavaCore\\Lesson07\\demo1.txt";
        try {
            String content = IOManager.readFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
