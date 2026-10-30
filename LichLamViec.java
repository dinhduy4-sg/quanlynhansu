
package quanlynhansu;

import java.util.Scanner;

public class LichLamViec {
    private String maLich;
    private String ngayLam;
    private String maCa;
    private String maNV;

    public LichLamViec() {}

    public LichLamViec(String maLich, String ngayLam, String maCa, String maNV) {
        this.maLich = maLich;
        this.ngayLam = ngayLam;
        this.maCa = maCa;
        this.maNV = maNV;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public String getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(String ngayLam) {
        this.ngayLam = ngayLam;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Lich: ");
        this.maLich = sc.nextLine();

        System.out.print("Nhap Ngay Lam (dd/mm/yyyy): ");
        this.ngayLam = sc.nextLine();

        System.out.print("Nhap Ma Ca: ");
        this.maCa = sc.nextLine();

        System.out.print("Nhap Ma Nhan Vien: ");
        this.maNV = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-15s | %-10s | %-10s\n",
                maLich, ngayLam, maCa, maNV);
    }

    public String toFileString() {
        return maLich + "," + ngayLam + "," + maCa + "," + maNV;
    }
}
