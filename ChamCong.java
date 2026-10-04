package quanlynhansu;

import java.util.Scanner;

public class ChamCong {
    private String maCC;
    private String maNV;
    private int thang;
    private int soNgayLamViec;
    private int soNgayNghi;

    public ChamCong() {}

    public ChamCong(String maCC, String maNV, int thang, int soNgayLamViec, int soNgayNghi) {
        this.maCC = maCC;
        this.maNV = maNV;
        this.thang = thang;
        this.soNgayLamViec = soNgayLamViec;
        this.soNgayNghi = soNgayNghi;
    }

    public String getMaCC() { return maCC; }
    public void setMaCC(String maCC) { this.maCC = maCC; }
    public String getMaNV() { return maNV; }
    public int getThang() { return thang; }
    public int getSoNgayLamViec() { return soNgayLamViec; }
    public int getSoNgayNghi() { return soNgayNghi; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Cham Cong: ");
        this.maCC = sc.nextLine();
        System.out.print("Nhap Ma NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhap Thang: ");
        this.thang = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap So Ngay Lam Viec: ");
        this.soNgayLamViec = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap So Ngay Nghi: ");
        this.soNgayNghi = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-10s | %-10s | Thang: %-3d | Ngay Lam: %-3d | Ngay Nghi: %-3d\n", 
                maCC, maNV, thang, soNgayLamViec, soNgayNghi);
    }

    public String toFileString() {
        return maCC + "," + maNV + "," + thang + "," + soNgayLamViec + "," + soNgayNghi;
    }
}