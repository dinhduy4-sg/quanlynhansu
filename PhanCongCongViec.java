
package quanlynhansu;

import java.util.Scanner;

public class PhanCongCongViec {
    private String maPhanCong;
    private String noiDungCongViec;
    private String thoiHan;
    private String trangThai;

    // Constructor mac dinh
    public PhanCongCongViec() {
    }

    // Constructor co tham so
    public PhanCongCongViec(String maPhanCong, String noiDungCongViec,
                            String thoiHan, String trangThai) {
        this.maPhanCong = maPhanCong;
        this.noiDungCongViec = noiDungCongViec;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
    }

    // Getter va Setter
    public String getMaPhanCong() {
        return maPhanCong;
    }

    public void setMaPhanCong(String maPhanCong) {
        this.maPhanCong = maPhanCong;
    }

    public String getNoiDungCongViec() {
        return noiDungCongViec;
    }

    public void setNoiDungCongViec(String noiDungCongViec) {
        this.noiDungCongViec = noiDungCongViec;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(String thoiHan) {
        this.thoiHan = thoiHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Nhap thong tin phan cong cong viec
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Phan Cong: ");
        this.maPhanCong = sc.nextLine();

        System.out.print("Nhap Noi Dung Cong Viec: ");
        this.noiDungCongViec = sc.nextLine();

        System.out.print("Nhap Thoi Han (dd/mm/yyyy): ");
        this.thoiHan = sc.nextLine();

        System.out.print("Nhap Trang Thai: ");
        this.trangThai = sc.nextLine();
    }

    // Xuat thong tin phan cong cong viec
    public void xuat() {
        System.out.printf("%-15s | %-30s | %-15s | %-20s\n",
                maPhanCong, noiDungCongViec, thoiHan, trangThai);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maPhanCong + ","
                + noiDungCongViec + ","
                + thoiHan + ","
                + trangThai;
    }
}
