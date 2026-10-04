package quanlynhansu;

import java.util.Scanner;

public class TruongPhong extends NhanVienChinhThuc {
    private double phuCapTrachNhiem;

    public TruongPhong() {
        super();
    }

    public TruongPhong(String maNV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, 
                       double luongCoBan, double heSoLuong, double phuCap, double phuCapTrachNhiem) {
        super(maNV, hoTen, ngaySinh, gioiTinh, diaChi, luongCoBan, heSoLuong, phuCap);
        this.phuCapTrachNhiem = phuCapTrachNhiem;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap Phu Cap Trach Nhiem Truong Phong: ");
        this.phuCapTrachNhiem = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCapTrachNhiem;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" (Phu cap trach nhiem: %.1f)\n", phuCapTrachNhiem);
    }
}