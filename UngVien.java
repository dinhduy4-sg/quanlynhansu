
package quanlynhansu;

import java.util.Scanner;

public class UngVien {
    private String maUngVien;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String viTriUngTuyen;

    // Constructor mac dinh
    public UngVien() {
    }

    // Constructor co tham so
    public UngVien(String maUngVien, String hoTen, String email,
                   String soDienThoai, String viTriUngTuyen) {
        this.maUngVien = maUngVien;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.viTriUngTuyen = viTriUngTuyen;
    }

    // Getter va Setter
    public String getMaUngVien() {
        return maUngVien;
    }

    public void setMaUngVien(String maUngVien) {
        this.maUngVien = maUngVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getViTriUngTuyen() {
        return viTriUngTuyen;
    }

    public void setViTriUngTuyen(String viTriUngTuyen) {
        this.viTriUngTuyen = viTriUngTuyen;
    }

    // Nhap thong tin ung vien
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Ung Vien: ");
        this.maUngVien = sc.nextLine();

        System.out.print("Nhap Ho Ten: ");
        this.hoTen = sc.nextLine();

        System.out.print("Nhap Email: ");
        this.email = sc.nextLine();

        System.out.print("Nhap So Dien Thoai: ");
        this.soDienThoai = sc.nextLine();

        System.out.print("Nhap Vi Tri Ung Tuyen: ");
        this.viTriUngTuyen = sc.nextLine();
    }

    // Xuat thong tin ung vien
    public void xuat() {
        System.out.printf("%-15s | %-25s | %-25s | %-15s | %-20s\n",
                maUngVien, hoTen, email, soDienThoai, viTriUngTuyen);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maUngVien + ","
                + hoTen + ","
                + email + ","
                + soDienThoai + ","
                + viTriUngTuyen;
    }
}
