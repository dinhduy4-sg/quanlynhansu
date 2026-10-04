package quanlynhansu;

import java.util.Scanner;

public class HopDong {
    private String maHD;
    private String maNV;
    private String loaiHD;
    private String ngayKy;
    private String ngayHetHan;

    public HopDong() {}

    public HopDong(String maHD, String maNV, String loaiHD, String ngayKy, String ngayHetHan) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.loaiHD = loaiHD;
        this.ngayKy = ngayKy;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma HD: ");
        this.maHD = sc.nextLine();
        System.out.print("Nhap Ma NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap Loai HD (Thu viec/1 nam/Vo thoi han): ");
        this.loaiHD = sc.nextLine();
        System.out.print("Nhap Ngay Ky: ");
        this.ngayKy = sc.nextLine();
        System.out.print("Nhap Ngay Het Han: ");
        this.ngayHetHan = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-10s | %-15s | %-12s | %-12s\n", maHD, maNV, loaiHD, ngayKy, ngayHetHan);
    }

    public String toFileString() {
        return maHD + "," + maNV + "," + loaiHD + "," + ngayKy + "," + ngayHetHan;
    }
}