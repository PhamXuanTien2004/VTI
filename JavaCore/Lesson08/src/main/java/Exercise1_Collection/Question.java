package Exercise1_Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question {
    Map<Integer, String> question6(){
        Map<Integer,String> students = new HashMap<>();
        students.put(1, "Phạm Xuân Tiến");
        students.put(2, "Phạm Xuân Tâm");
        students.put(3, "Phạm Xuân Bách");
        students.put(4, "Phạm Xuân Thùy Linh");
        students.put(5, "Mai Trường Sơn");
        students.put(6, "Mai Hương Giang");
        students.put(7, "Nguyễn Thùy Trang");
        return students;
    }
    void question7() {
        Map<Integer, String> students = question6();

        System.out.println("Danh sách key của student:");
        int index = 1;
        for (Integer key : students.keySet()) {
            System.out.println("Key student " + index + " = " + key);
            index++;
        }

        System.out.println("----------------------------------------------");

        System.out.println("Danh sách value của student:");
        index = 1;
        for (String value : students.values()) {
            System.out.println("Value student " + index + " = " + value);
            index++;
        }

        Set<String> studentsSet = new HashSet<>();
        for (String value : students.values()){
            studentsSet.add(value);
        }
        System.out.println("studentsSet = " + studentsSet);


    }
    public static void main(String[] args) {
        Question q = new Question();
        q.question7();
    }
}
