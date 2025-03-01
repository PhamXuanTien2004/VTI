package Abstraction;

public class HinhVuong extends HinhChuNhat{
    public HinhVuong(int canh) {
        super(canh, canh);
    }

    @Override
    public int chuVi() {
        System.out.println("Tính chu vi theo hình vuông");
        return super.chuVi();
    }

    @Override
    public int dienTich() {
        System.out.println("Tính diện tích theo hình vuông");
        return super.dienTich();
    }

    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(3,5);
        System.out.println(hcn.chuVi());
        System.out.println(hcn.dienTich());
        HinhVuong hv = new HinhVuong(6);
        System.out.println(hv.chuVi());
        System.out.println(hv.dienTich());
    }
}
