
package quanlynhansu;

import java.util.Scanner;

public class Thuong {
    private String maThuong;
    private String lyDo;
    private double soTienThuong;
    private String ngayThuong;

    // Constructor mac dinh
    public Thuong() {
    }

    // Constructor co tham so
    public Thuong(String maThuong, String lyDo,
                  double soTienThuong, String ngayThuong) {
        this.maThuong = maThuong;
        this.lyDo = lyDo;
        this.soTienThuong = soTienThuong;
        this.ngayThuong = ngayThuong;
    }

    // Getter va Setter
    public String getMaThuong() {
        return maThuong;
    }

    public void setMaThuong(String maThuong) {
        this.maThuong = maThuong;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public double getSoTienThuong() {
        return soTienThuong;
    }

    public void setSoTienThuong(double soTienThuong) {
        this.soTienThuong = soTienThuong;
    }

    public String getNgayThuong() {
        return ngayThuong;
    }

    public void setNgayThuong(String ngayThuong) {
        this.ngayThuong = ngayThuong;
    }

    // Nhap thong tin thuong
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Thuong: ");
        this.maThuong = sc.nextLine();

        System.out.print("Nhap Ly Do Thuong: ");
        this.lyDo = sc.nextLine();

        System.out.print("Nhap So Tien Thuong: ");
        this.soTienThuong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Ngay Thuong (dd/mm/yyyy): ");
        this.ngayThuong = sc.nextLine();
    }

    // Xuat thong tin thuong
    public void xuat() {
        System.out.printf("%-15s | %-30s | %-20.2f | %-15s\n",
                maThuong, lyDo, soTienThuong, ngayThuong);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maThuong + ","
                + lyDo + ","
                + soTienThuong + ","
                + ngayThuong;
    }
}
