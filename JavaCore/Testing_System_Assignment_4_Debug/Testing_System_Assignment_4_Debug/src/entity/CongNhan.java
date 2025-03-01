package entity;

import java.util.Scanner;

public class CongNhan extends CanBo {

	private int bac;

	public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int bac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.bac = bac;
	}

	public CongNhan() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào Bac: ");
		bac = scanner.nextInt();
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCongNhan [bac=" + bac + "]";
	}

}
