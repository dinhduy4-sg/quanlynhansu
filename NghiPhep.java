
package quanlynhansu;

import java.util.Scanner;

public class NghiPhep {
    private String maDonNghiPhep;
    private String ngayNghi;
    private int soNgayNghi;
    private String lyDo;
    private String trangThaiDuyet;

    // Constructor mac dinh
    public NghiPhep() {
    }

    // Constructor co tham so
    public NghiPhep(String maDonNghiPhep, String ngayNghi,
                    int soNgayNghi, String lyDo, String trangThaiDuyet) {
        this.maDonNghiPhep = maDonNghiPhep;
        this.ngayNghi = ngayNghi;
        this.soNgayNghi = soNgayNghi;
        this.lyDo = lyDo;
        this.trangThaiDuyet = trangThaiDuyet;
    }

    // Getter va Setter
    public String getMaDonNghiPhep() {
        return maDonNghiPhep;
    }

    public void setMaDonNghiPhep(String maDonNghiPhep) {
        this.maDonNghiPhep = maDonNghiPhep;
    }

    public String getNgayNghi() {
        return ngayNghi;
    }

    public void setNgayNghi(String ngayNghi) {
        this.ngayNghi = ngayNghi;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTrangThaiDuyet() {
        return trangThaiDuyet;
    }

    public void setTrangThaiDuyet(String trangThaiDuyet) {
        this.trangThaiDuyet = trangThaiDuyet;
    }

    // Nhap thong tin nghi phep
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Don Nghi Phep: ");
        this.maDonNghiPhep = sc.nextLine();

        System.out.print("Nhap Ngay Nghi (dd/mm/yyyy): ");
        this.ngayNghi = sc.nextLine();

        System.out.print("Nhap So Ngay Nghi: ");
        this.soNgayNghi = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap Ly Do Nghi: ");
        this.lyDo = sc.nextLine();

        System.out.print("Nhap Trang Thai Duyet: ");
        this.trangThaiDuyet = sc.nextLine();
    }

    // Xuat thong tin nghi phep
    public void xuat() {
        System.out.printf("%-18s | %-15s | %-12d | %-25s | %-20s\n",
                maDonNghiPhep, ngayNghi, soNgayNghi, lyDo, trangThaiDuyet);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maDonNghiPhep + ","
                + ngayNghi + ","
                + soNgayNghi + ","
                + lyDo + ","
                + trangThaiDuyet;
    }
}
