
package quanlynhansu;

import java.util.Scanner;

public class BuoiPhongVan {
    private String maPhongVan;
    private String thoiGian;
    private String nguoiPhongVan;
    private String ketQua;

    // Constructor mac dinh
    public BuoiPhongVan() {
    }

    // Constructor co tham so
    public BuoiPhongVan(String maPhongVan, String thoiGian,
                        String nguoiPhongVan, String ketQua) {
        this.maPhongVan = maPhongVan;
        this.thoiGian = thoiGian;
        this.nguoiPhongVan = nguoiPhongVan;
        this.ketQua = ketQua;
    }

    // Getter va Setter
    public String getMaPhongVan() {
        return maPhongVan;
    }

    public void setMaPhongVan(String maPhongVan) {
        this.maPhongVan = maPhongVan;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNguoiPhongVan() {
        return nguoiPhongVan;
    }

    public void setNguoiPhongVan(String nguoiPhongVan) {
        this.nguoiPhongVan = nguoiPhongVan;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    // Nhap thong tin buoi phong van
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Phong Van: ");
        this.maPhongVan = sc.nextLine();

        System.out.print("Nhap Thoi Gian (dd/mm/yyyy HH:mm): ");
        this.thoiGian = sc.nextLine();

        System.out.print("Nhap Nguoi Phong Van: ");
        this.nguoiPhongVan = sc.nextLine();

        System.out.print("Nhap Ket Qua Phong Van: ");
        this.ketQua = sc.nextLine();
    }

    // Xuat thong tin buoi phong van
    public void xuat() {
        System.out.printf("%-15s | %-22s | %-25s | %-20s\n",
                maPhongVan, thoiGian, nguoiPhongVan, ketQua);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maPhongVan + ","
                + thoiGian + ","
                + nguoiPhongVan + ","
                + ketQua;
    }
}
