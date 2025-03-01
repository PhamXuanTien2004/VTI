package encapsulation;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private float point;

    public Student(String name, String hometown, float point) {
        this.name = name;
        this.hometown = hometown;
        this.point = point;
    }

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.point = 0f;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    void show_infor(){
        System.out.println("Thông tin sinh viên: ");
        System.out.println("Name: "+ name);
        System.out.printf("Học lực: ");
        if(point<4.0){
            System.out.println("Yếu");
        } else if(point>=4.0 && point<6.0){
            System.out.println("Trung Bình");
        } else if (point>=6.0 && point<8.0) {
            System.out.println("Khá");
        } else {
            System.out.println("Giỏi");
        }
    }
}
