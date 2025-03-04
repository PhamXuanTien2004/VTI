package Abstraction;

public class TuyenSinh implements ITuyenSinh {
    private int id;
    private String name;
    private String address;
    private KhoiThi khoi_thi
            ;

    public TuyenSinh(int id, String name, String address, KhoiThi khoi_thi
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.khoi_thi = khoi_thi
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public KhoiThi getKhoi_thi() {
        return khoi_thi;
    }

    public void setKhoi_thi(KhoiThi khoi_thi) {
        this.khoi_thi = khoi_thi;
    }

    @Override
    public void display() {
        System.out.println(
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", khoi_thi=" + khoi_thi);
    }

    @Override
    public void findById(int a) {
        int count = 0;
        if(getId() == a){
            System.out.println("Thí sinh có sbd " + a + " là: ");
            display();
        }
    }
}
