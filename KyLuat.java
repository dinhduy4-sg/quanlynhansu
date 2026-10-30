
package quanlynhansu;

import java.util.Scanner;

public class KyLuat {
    private String maQuyetDinh;
    private String hinhThucKyLuat;
    private String lyDo;
    private String ngayQuyetDinh;

    // Constructor mac dinh
    public KyLuat() {
    }

    // Constructor co tham so
    public KyLuat(String maQuyetDinh, String hinhThucKyLuat,
                  String lyDo, String ngayQuyetDinh) {
        this.maQuyetDinh = maQuyetDinh;
        this.hinhThucKyLuat = hinhThucKyLuat;
        this.lyDo = lyDo;
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    // Getter va Setter
    public String getMaQuyetDinh() {
        return maQuyetDinh;
    }

    public void setMaQuyetDinh(String maQuyetDinh) {
        this.maQuyetDinh = maQuyetDinh;
    }

    public String getHinhThucKyLuat() {
        return hinhThucKyLuat;
    }

    public void setHinhThucKyLuat(String hinhThucKyLuat) {
        this.hinhThucKyLuat = hinhThucKyLuat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getNgayQuyetDinh() {
        return ngayQuyetDinh;
    }

    public void setNgayQuyetDinh(String ngayQuyetDinh) {
        this.ngayQuyetDinh = ngayQuyetDinh;
    }

    // Nhap thong tin ky luat
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Quyet Dinh: ");
        this.maQuyetDinh = sc.nextLine();

        System.out.print("Nhap Hinh Thuc Ky Luat: ");
        this.hinhThucKyLuat = sc.nextLine();

        System.out.print("Nhap Ly Do: ");
        this.lyDo = sc.nextLine();

        System.out.print("Nhap Ngay Quyet Dinh (dd/mm/yyyy): ");
        this.ngayQuyetDinh = sc.nextLine();
    }

    // Xuat thong tin ky luat
    public void xuat() {
        System.out.printf("%-15s | %-25s | %-30s | %-15s\n",
                maQuyetDinh, hinhThucKyLuat, lyDo, ngayQuyetDinh);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maQuyetDinh + ","
                + hinhThucKyLuat + ","
                + lyDo + ","
                + ngayQuyetDinh;
    }
}
