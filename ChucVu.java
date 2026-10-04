package quanlynhansu;

import java.util.Scanner;

public class ChucVu {
    private String maCV;
    private String tenCV;
    private double heSoPhuCap;

    public ChucVu() {}

    public ChucVu(String maCV, String tenCV, double heSoPhuCap) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.heSoPhuCap = heSoPhuCap;
    }

    public String getMaCV() { return maCV; }
    public void setMaCV(String maCV) { this.maCV = maCV; }
    public String getTenCV() { return tenCV; }
    public void setTenCV(String tenCV) { this.tenCV = tenCV; }
    public double getHeSoPhuCap() { return heSoPhuCap; }
    public void setHeSoPhuCap(double heSoPhuCap) { this.heSoPhuCap = heSoPhuCap; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Chuc Vu: ");
        this.maCV = sc.nextLine();
        System.out.print("Nhap Ten Chuc Vu: ");
        this.tenCV = sc.nextLine();
        System.out.print("Nhap He So Phu Cap: ");
        this.heSoPhuCap = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("%-10s | %-20s | %-10.2f\n", maCV, tenCV, heSoPhuCap);
    }

    public String toFileString() {
        return maCV + "," + tenCV + "," + heSoPhuCap;
    }
}