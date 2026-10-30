
package quanlynhansu;

import java.util.Scanner;

public class BaoHiem {
    private String maBaoHiem;
    private String loaiBaoHiem;
    private double mucDong;
    private String ngayBatDau;

    // Constructor mac dinh
    public BaoHiem() {
    }

    // Constructor co tham so
    public BaoHiem(String maBaoHiem, String loaiBaoHiem,
                   double mucDong, String ngayBatDau) {
        this.maBaoHiem = maBaoHiem;
        this.loaiBaoHiem = loaiBaoHiem;
        this.mucDong = mucDong;
        this.ngayBatDau = ngayBatDau;
    }

    // Getter va Setter
    public String getMaBaoHiem() {
        return maBaoHiem;
    }

    public void setMaBaoHiem(String maBaoHiem) {
        this.maBaoHiem = maBaoHiem;
    }

    public String getLoaiBaoHiem() {
        return loaiBaoHiem;
    }

    public void setLoaiBaoHiem(String loaiBaoHiem) {
        this.loaiBaoHiem = loaiBaoHiem;
    }

    public double getMucDong() {
        return mucDong;
    }

    public void setMucDong(double mucDong) {
        this.mucDong = mucDong;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    // Nhap thong tin bao hiem
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Bao Hiem: ");
        this.maBaoHiem = sc.nextLine();

        System.out.print("Nhap Loai Bao Hiem: ");
        this.loaiBaoHiem = sc.nextLine();

        System.out.print("Nhap Muc Dong: ");
        this.mucDong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Ngay Bat Dau (dd/mm/yyyy): ");
        this.ngayBatDau = sc.nextLine();
    }

    // Xuat thong tin bao hiem
    public void xuat() {
        System.out.printf("%-15s | %-20s | %-20.2f | %-15s\n",
                maBaoHiem, loaiBaoHiem, mucDong, ngayBatDau);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maBaoHiem + ","
                + loaiBaoHiem + ","
                + mucDong + ","
                + ngayBatDau;
    }
}
