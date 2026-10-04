package quanlynhansu;

import java.util.Scanner;

public class NhanVienThoiVu extends NhanVien {
    private double soGioLam;
    private double donGiaGio;

    public NhanVienThoiVu() {
        super();
    }

    public NhanVienThoiVu(String maNV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, 
                          double luongCoBan, double soGioLam, double donGiaGio) {
        super(maNV, hoTen, ngaySinh, gioiTinh, diaChi, luongCoBan);
        this.soGioLam = soGioLam;
        this.donGiaGio = donGiaGio;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap So Gio Lam: ");
        this.soGioLam = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap Don Gia Moi Gio: ");
        this.donGiaGio = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return this.luongCoBan + (this.soGioLam * this.donGiaGio);
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | GioLam: %-4.1f | DonGia: %-6.1f | Luong: %-10.1f [Thoi Vu]\n", 
                soGioLam, donGiaGio, tinhLuong());
    }

    @Override
    public String toFileString() {
        return "TV," + maNV + "," + hoTen + "," + ngaySinh + "," + gioiTinh + "," + diaChi + "," 
                + luongCoBan + "," + soGioLam + "," + donGiaGio;
    }
}