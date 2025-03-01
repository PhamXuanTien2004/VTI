package innerclass;

import innerclass.entity.Student;

public class InnerDemo {
    public static void main(String[] args) {
        Student student1 = new Student(1,"a");
        Student.Skin skin1 = new Student.Skin("red");
        Student.Skin skin2 = new Student.Skin("blue");

        student1.setSkin(skin1);
    }
}
