
package quanlynhansu;

import java.util.Scanner;

public class ChiTietLuong {
    private double luongCoBan;
    private double phuCap;
    private double tienThuong;
    private double tienPhat;
    private double khauTru;

    // Constructor mac dinh
    public ChiTietLuong() {
    }

    // Constructor co tham so
    public ChiTietLuong(double luongCoBan, double phuCap,
                        double tienThuong, double tienPhat,
                        double khauTru) {
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.khauTru = khauTru;
    }

    // Getter va Setter
    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public double getKhauTru() {
        return khauTru;
    }

    public void setKhauTru(double khauTru) {
        this.khauTru = khauTru;
    }

    // Nhap thong tin chi tiet luong
    public void nhap(Scanner sc) {
        System.out.print("Nhap Luong Co Ban: ");
        this.luongCoBan = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Phu Cap: ");
        this.phuCap = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Tien Thuong: ");
        this.tienThuong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Tien Phat: ");
        this.tienPhat = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Khau Tru: ");
        this.khauTru = Double.parseDouble(sc.nextLine());
    }

    // Tinh tong luong thuc nhan
    public double tinhLuongThucNhan() {
        return luongCoBan + phuCap + tienThuong - tienPhat - khauTru;
    }

    // Xuat thong tin chi tiet luong
    public void xuat() {
        System.out.printf(
                "%-15.2f | %-15.2f | %-15.2f | %-15.2f | %-15.2f | %-15.2f\n",
                luongCoBan, phuCap, tienThuong, tienPhat, khauTru,
                tinhLuongThucNhan()
        );
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return luongCoBan + ","
                + phuCap + ","
                + tienThuong + ","
                + tienPhat + ","
                + khauTru;
    }
}
