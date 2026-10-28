package quanlynhansu;

import java.util.Scanner;

public abstract class NhanVien {
    public static int demNV = 0; // Thuộc tính static đếm và tự tăng

    protected String maNV;
    protected String hoTen;
    protected String ngaySinh;
    protected String gioiTinh;
    protected String diaChi;
    protected double luongCoBan;

    public NhanVien() {
        demNV++;
    }

    public NhanVien(String maNV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.luongCoBan = luongCoBan;
        demNV++;
    }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap Ho Ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhap Ngay Sinh (dd/mm/yyyy): ");
        this.ngaySinh = sc.nextLine();
        System.out.print("Nhap Gioi Tinh: ");
        this.gioiTinh = sc.nextLine();
        System.out.print("Nhap Dia Chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("Nhap Luong Co Ban: ");
        this.luongCoBan = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-8s | %-18s | %-10s | %-6s | %-12s | %-10.1f", 
                maNV, hoTen, ngaySinh, gioiTinh, diaChi, luongCoBan);
    }

    // Phương thức trừu tượng đa hình
    public abstract double tinhLuong();
    public abstract String toFileString();
}
