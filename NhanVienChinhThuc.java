package quanlynhansu;

import java.util.Scanner;

public class NhanVienChinhThuc extends NhanVien {
    private double heSoLuong;
    private double phuCap;

    public NhanVienChinhThuc() {
        super();
    }

    public NhanVienChinhThuc(String maNV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, 
                             double luongCoBan, double heSoLuong, double phuCap) {
        super(maNV, hoTen, ngaySinh, gioiTinh, diaChi, luongCoBan);
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap He So Luong: ");
        this.heSoLuong = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap Phu Cap: ");
        this.phuCap = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhLuong() {
        return (this.luongCoBan * this.heSoLuong) + this.phuCap;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | HSL: %-4.1f | PC: %-8.1f | Luong: %-10.1f [Chinh Thuc]\n", 
                heSoLuong, phuCap, tinhLuong());
    }

    @Override
    public String toFileString() {
        return "CT," + maNV + "," + hoTen + "," + ngaySinh + "," + gioiTinh + "," + diaChi + "," 
                + luongCoBan + "," + heSoLuong + "," + phuCap;
    }
}