package inheritence;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien(int age, String name, String address,GioiTinh gioiTinh, String congViec) {
        super(age, name, address, gioiTinh);
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "congViec='" + congViec + '\'' +
                '}';
    }
}
