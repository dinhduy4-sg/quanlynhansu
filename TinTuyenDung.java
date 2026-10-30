
package quanlynhansu;

import java.util.Scanner;

public class TinTuyenDung {
    private String maTin;
    private String viTri;
    private String yeuCau;
    private double mucLuong;
    private String hanNop;

    // Constructor mac dinh
    public TinTuyenDung() {
    }

    // Constructor co tham so
    public TinTuyenDung(String maTin, String viTri, String yeuCau,
                        double mucLuong, String hanNop) {
        this.maTin = maTin;
        this.viTri = viTri;
        this.yeuCau = yeuCau;
        this.mucLuong = mucLuong;
        this.hanNop = hanNop;
    }

    // Getter va Setter
    public String getMaTin() {
        return maTin;
    }

    public void setMaTin(String maTin) {
        this.maTin = maTin;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    public String getHanNop() {
        return hanNop;
    }

    public void setHanNop(String hanNop) {
        this.hanNop = hanNop;
    }

    // Nhap thong tin tin tuyen dung
    public void nhap(Scanner sc) {
        System.out.print("Nhap Ma Tin: ");
        this.maTin = sc.nextLine();

        System.out.print("Nhap Vi Tri Tuyen Dung: ");
        this.viTri = sc.nextLine();

        System.out.print("Nhap Yeu Cau: ");
        this.yeuCau = sc.nextLine();

        System.out.print("Nhap Muc Luong: ");
        this.mucLuong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap Han Nop (dd/mm/yyyy): ");
        this.hanNop = sc.nextLine();
    }

    // Xuat thong tin tin tuyen dung
    public void xuat() {
        System.out.printf("%-15s | %-20s | %-30s | %-20.2f | %-15s\n",
                maTin, viTri, yeuCau, mucLuong, hanNop);
    }

    // Chuyen thong tin thanh chuoi de ghi file
    public String toFileString() {
        return maTin + ","
                + viTri + ","
                + yeuCau + ","
                + mucLuong + ","
                + hanNop;
    }
}
