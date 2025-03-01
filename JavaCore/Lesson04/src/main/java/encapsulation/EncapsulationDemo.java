package encapsulation;

public class EncapsulationDemo {
    public static void main(String[] args) {
    //Tính đóng gói
    //Su dung de che giau du lieu
    //1. Su dung private cho thuộc tính
    //2. Thêm getter: xuất dữ liệu
        // / setter: truyền dữ liêệu
    Account account = new Account(1000);
    System.out.println(account.getBalance());
    }
}
