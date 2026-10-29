
package quanlynhansu;

import java.util.Scanner;

public class HopDongLaoDong {
    private String maHopDong;
    private String ngayKy;
    private String ngayHetHan;
    private String loaiHopDong;

    public HopDongLaoDong() {}

    public HopDongLaoDong(String maHopDong, String ngayKy, String ngayHetHan, String loaiHopDong) {
        this.maHopDong = maHopDong;
        this.ngayKy = ngayKy;
        this.ngayHetHan = ngayHetHan;
        this.loaiHopDong = loaiHopDong;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(String loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Hop Dong: ");
        this.maHopDong = sc.nextLine();

        System.out.print("Nhap Ngay Ky (dd/mm/yyyy): ");
        this.ngayKy = sc.nextLine();

        System.out.print("Nhap Ngay Het Han (dd/mm/yyyy): ");
        this.ngayHetHan = sc.nextLine();

        System.out.print("Nhap Loai Hop Dong: ");
        this.loaiHopDong = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-12s | %-12s | %-12s | %-20s\n",
                maHopDong, ngayKy, ngayHetHan, loaiHopDong);
    }

    public String toFileString() {
        return maHopDong + "," + ngayKy + "," + ngayHetHan + "," + loaiHopDong;
    }
}
