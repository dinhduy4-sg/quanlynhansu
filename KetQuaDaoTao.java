
package quanlynhansu;

import java.util.Scanner;

public class KetQuaDaoTao {
    private String maNV;
    private String maKhoaHoc;
    private double diemKetQua;
    private String xepLoai;

    // Constructor mac dinh
    public KetQuaDaoTao() {
    }

    // Constructor co tham so
    public KetQuaDaoTao(String maNV, String maKhoaHoc,
                        double diemKetQua, String xepLoai) {
        this.maNV = maNV;
        this.maKhoaHoc = maKhoaHoc;
        this.diemKetQua = diemKetQua;
        this.xepLoai = xepLoai;
    }

    // Getter va Setter
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public double getDiemKetQua() {
        return diemKetQua;
    }

    public void setDiemKetQua(double diemKetQua) {
        this.diemKetQua = diemKetQua;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    // Nhap thong tin ket qua dao tao
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Nhan Vien: ");
        this.maNV = sc.nextLine();

        System.out.print("Nhap Ma Khoa Hoc: ");
        this.maKhoaHoc = sc.nextLine();

        System.out.print("Nhap Diem Ket Qua: ");
        this.diemKetQua = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Xep Loai: ");
        this.xepLoai = sc.nextLine();
    }

    // Xuat thong tin ket qua dao tao
    public void xuat() {
        System.out.printf("%-15s | %-15s | %-15.2f | %-20s\n",
                maNV, maKhoaHoc, diemKetQua, xepLoai);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maNV + ","
                + maKhoaHoc + ","
                + diemKetQua + ","
                + xepLoai;
    }
}
