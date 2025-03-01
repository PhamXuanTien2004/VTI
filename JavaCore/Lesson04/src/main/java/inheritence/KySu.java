package inheritence;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu(int age, String name, String address,GioiTinh gioiTinh, String nganhDaoTao) {
        super(age, name, address, gioiTinh);
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return "KySu{" +
                "nganhDaoTao='" + nganhDaoTao + '\'' +
                '}';
    }
}
