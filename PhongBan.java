package quanlynhansu;

import java.util.Scanner;

public class PhongBan {
    private String maPB;
    private String tenPB;
    private String sdtLienHe;

    public PhongBan() {}

    public PhongBan(String maPB, String tenPB, String sdtLienHe) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.sdtLienHe = sdtLienHe;
    }

    public String getMaPB() { return maPB; }
    public void setMaPB(String maPB) { this.maPB = maPB; }
    public String getTenPB() { return tenPB; }
    public void setTenPB(String tenPB) { this.tenPB = tenPB; }
    public String getSdtLienHe() { return sdtLienHe; }
    public void setSdtLienHe(String sdtLienHe) { this.sdtLienHe = sdtLienHe; }

    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma PB: ");
        this.maPB = sc.nextLine();
        System.out.print("Nhap Ten PB: ");
        this.tenPB = sc.nextLine();
        System.out.print("Nhap SDT Lien He: ");
        this.sdtLienHe = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-20s | %-12s\n", maPB, tenPB, sdtLienHe);
    }

    public String toFileString() {
        return maPB + "," + tenPB + "," + sdtLienHe;
    }
}