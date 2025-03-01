package inheritence;

public  class CongNhan extends CanBo{
    private int bac;

    public CongNhan(int age, String name, String address,GioiTinh gioiTinh, int bac) {
        super(age, name, address, gioiTinh );
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "bac=" + bac +
                '}';
    }
}
