package inheritence;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_5 {
    private ArrayList<CanBo> listCanBo;
    private Scanner sc;

    public Exercise_5() {
        listCanBo = new ArrayList<CanBo>();
        sc = new Scanner(System.in);
    }

    public void question1() {
    }

    public void question2() {
        menu();
    }

    public void menu() {
        while (true) {
            System.out.println("======================================================================");
            System.out.println("================= Lựa chọn chức năng bạn muốn sử dụng ================");
            System.out.println("=== 1. Thêm mới cán bộ.                                          ===");
            System.out.println("=== 2. Tìm kiếm theo họ tên.                                     ===");
            System.out.println("=== 3. Hiển thị thông tin về danh sách các cán bộ.               ===");
            System.out.println("=== 4. Nhập vào tên của cán bộ và xóa cán bộ đó.                 ===");
            System.out.println("=== 5. Thoát khỏi chương trình.                                  ===");
            System.out.println("======================================================================");

            System.out.print("Nhập lựa chọn của bạn: ");
            int menuChoose = sc.nextInt();
            sc.nextLine();

            switch (menuChoose) {
                case 1:
                    addCanBo();
                    break;
                case 2:
                    // searchCanBo();
                    break;
                case 3:
                    // displayCanBo();
                    break;
                case 4:
                    // deleteCanBo();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return; // Kết thúc vòng lặp và thoát chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1 đến 5.");
            }
        }
    }
    public CanBo information() {
        System.out.println("Nhập vào tên: ");
        String name = sc.nextLine();

        System.out.println("Nhập vào tuổi: ");
        int age = sc.nextInt();
        sc.nextLine(); // Xử lý ký tự xuống dòng còn sót lại

        System.out.println("Nhập vào giới tính  1.Male, 2.Female, 3.Unknown: ");
        int flag = sc.nextInt();
        sc.nextLine(); // Xử lý ký tự xuống dòng còn sót lại

        // Gán giá trị mặc định để tránh lỗi biến chưa khởi tạo
        GioiTinh gender = GioiTinh.UNKNOWN;

        switch (flag) {
            case 1:
                gender = GioiTinh.MALE;
                break;
            case 2:
                gender = GioiTinh.FEMALE;
                break;
            case 3:
                gender = GioiTinh.UNKNOWN;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, mặc định là UNKNOWN.");
        }

        System.out.println("Nhập vào địa chỉ: ");
        String address = sc.nextLine(); // Không bị lỗi nhập liệu nữa

        return new CanBo(age,  name, address, gender);
    }

    private void addCanBo(){
        System.out.println("======================================================================");
        System.out.println("================= Lựa chọn chức năng bạn muốn sử dụng ================");
        System.out.println("=== 1. Công nhân.                                                ===");
        System.out.println("=== 2. Kỹ sư.                                                    ===");
        System.out.println("=== 3. Nhân viên.                                                ===");
        System.out.println("=== 4. Thoát khỏi chương trình.                                  ===");
        System.out.println("======================================================================");
        System.out.print("Nhập lựa chọn của bạn: ");
        int menuChoose = sc.nextInt();
        sc.nextLine();

        switch (menuChoose){
            case 1:
                System.out.println("Công nhân");
                System.out.println("Bậc số bao nhiêu? ");
                int bac= sc.nextInt();
                sc.nextLine();
                CanBo canBo = information();
                CanBo congnhan = new CongNhan(canBo.age,canBo.name, canBo.address,  canBo.gioiTinh, canBo.age);
                listCanBo.add(congnhan);
                break;
            case 2:
                System.out.println("Kỹ sư");
                System.out.println("Ngành gì? ");
                String nganh = sc.nextLine();
                sc.nextLine();

                break;
            case 3:
                System.out.println("Nhân viên");
                System.out.println("Công việc gì? ");
                String congViec = sc.nextLine();
                sc.nextLine();
                break;
            case 4:
                System.out.println("Thoát chương trình.");
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập từ 1 đến 4.");
        }
    }

    public static void main(String[] args) {

    }
}
