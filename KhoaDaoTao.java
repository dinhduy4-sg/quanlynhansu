
package quanlynhansu;

import java.util.Scanner;

public class KhoaDaoTao {
    private String maKhoaHoc;
    private String tenKhoaHoc;
    private String thoiGian;
    private double chiPhi;

    // Constructor mac dinh
    public KhoaDaoTao() {
    }

    // Constructor co tham so
    public KhoaDaoTao(String maKhoaHoc, String tenKhoaHoc,
                      String thoiGian, double chiPhi) {
        this.maKhoaHoc = maKhoaHoc;
        this.tenKhoaHoc = tenKhoaHoc;
        this.thoiGian = thoiGian;
        this.chiPhi = chiPhi;
    }

    // Getter va Setter
    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    // Nhap thong tin khoa dao tao
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Khoa Hoc: ");
        this.maKhoaHoc = sc.nextLine();

        System.out.print("Nhap Ten Khoa Hoc: ");
        this.tenKhoaHoc = sc.nextLine();

        System.out.print("Nhap Thoi Gian Dao Tao: ");
        this.thoiGian = sc.nextLine();

        System.out.print("Nhap Chi Phi Dao Tao: ");
        this.chiPhi = Double.parseDouble(sc.nextLine());
    }

    // Xuat thong tin khoa dao tao
    public void xuat() {
        System.out.printf("%-15s | %-25s | %-20s | %-18.2f\n",
                maKhoaHoc, tenKhoaHoc, thoiGian, chiPhi);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maKhoaHoc + ","
                + tenKhoaHoc + ","
                + thoiGian + ","
                + chiPhi;
    }
}
