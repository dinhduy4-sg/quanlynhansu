
package quanlynhansu;

import java.util.Scanner;

public class CaLamViec {
    private String maCa;
    private String tenCa;
    private String gioBatDau;
    private String gioKetThuc;

    public CaLamViec() {}

    public CaLamViec(String maCa, String tenCa, String gioBatDau, String gioKetThuc) {
        this.maCa = maCa;
        this.tenCa = tenCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    public String getMaCa() {
        return maCa;
    }

    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Ca: ");
        this.maCa = sc.nextLine();

        System.out.print("Nhap Ten Ca: ");
        this.tenCa = sc.nextLine();

        System.out.print("Nhap Gio Bat Dau (HH:mm): ");
        this.gioBatDau = sc.nextLine();

        System.out.print("Nhap Gio Ket Thuc (HH:mm): ");
        this.gioKetThuc = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-20s | %-15s | %-15s\n",
                maCa, tenCa, gioBatDau, gioKetThuc);
    }

    public String toFileString() {
        return maCa + "," + tenCa + "," + gioBatDau + "," + gioKetThuc;
    }
}
