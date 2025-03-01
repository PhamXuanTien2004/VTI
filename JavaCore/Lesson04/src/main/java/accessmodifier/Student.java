package accessmodifier;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private int diem;
    private String hocLuc;

    public Student (String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.diem = 0;
        this.hocLuc= null;
    }

    public int getDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap diem cua sinh vien: ");
        diem = scanner.nextInt();
        return diem;
    }

    public void setDiem(int diem) {
        this.diem=diem;
    }

    public String getHocLuc(int diem) {
        if(diem< 4)
        { hocLuc = "Yeu";}
        else if (diem> 4 && diem<6) {
            hocLuc = "TB";
        } else if (diem >6 && diem <8) {
            hocLuc="Kha";
        } else {hocLuc="Gioi";}

        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", diem=" + diem +
                ", hocLuc='" + hocLuc + '\'' +
                '}';
    }
}