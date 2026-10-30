
package quanlynhansu;

import java.util.Scanner;

public class HoSoUngTuyen {
    private String maHoSo;
    private String ungVien;
    private String tinTuyenDung;
    private String ngayNop;
    private String trangThai;

    // Constructor mac dinh
    public HoSoUngTuyen() {
    }

    // Constructor co tham so
    public HoSoUngTuyen(String maHoSo, String ungVien,
                        String tinTuyenDung, String ngayNop,
                        String trangThai) {
        this.maHoSo = maHoSo;
        this.ungVien = ungVien;
        this.tinTuyenDung = tinTuyenDung;
        this.ngayNop = ngayNop;
        this.trangThai = trangThai;
    }

    // Getter va Setter
    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public String getUngVien() {
        return ungVien;
    }

    public void setUngVien(String ungVien) {
        this.ungVien = ungVien;
    }

    public String getTinTuyenDung() {
        return tinTuyenDung;
    }

    public void setTinTuyenDung(String tinTuyenDung) {
        this.tinTuyenDung = tinTuyenDung;
    }

    public String getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(String ngayNop) {
        this.ngayNop = ngayNop;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Nhap thong tin ho so ung tuyen
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Ho So: ");
        this.maHoSo = sc.nextLine();

        System.out.print("Nhap Ma Ung Vien: ");
        this.ungVien = sc.nextLine();

        System.out.print("Nhap Ma Tin Tuyen Dung: ");
        this.tinTuyenDung = sc.nextLine();

        System.out.print("Nhap Ngay Nop (dd/mm/yyyy): ");
        this.ngayNop = sc.nextLine();

        System.out.print("Nhap Trang Thai Ho So: ");
        this.trangThai = sc.nextLine();
    }

    // Xuat thong tin ho so ung tuyen
    public void xuat() {
        System.out.printf("%-15s | %-15s | %-20s | %-15s | %-20s\n",
                maHoSo, ungVien, tinTuyenDung, ngayNop, trangThai);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maHoSo + ","
                + ungVien + ","
                + tinTuyenDung + ","
                + ngayNop + ","
                + trangThai;
    }
}
