package quanlynhansu;

import java.util.Scanner;

public class DanhSachPhongBan implements IThaoTac {
    private PhongBan[] dsPB;
    private int soLuong;

    public DanhSachPhongBan() {
        dsPB = new PhongBan[10];
        soLuong = 0;
    }

    public int getSoLuong() { return soLuong; }
    public PhongBan[] getDsPB() { return dsPB; }

    private void noiRongMang() {
        PhongBan[] moi = new PhongBan[dsPB.length * 2];
        for (int i = 0; i < soLuong; i++) moi[i] = dsPB[i];
        dsPB = moi;
    }

    public void themVaoCuoi(PhongBan pb) {
        if (soLuong == dsPB.length) noiRongMang();
        dsPB[soLuong++] = pb;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        PhongBan pb = new PhongBan();
        pb.nhap(sc);
        themVaoCuoi(pb);
        System.out.println("Them phong ban thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach phong ban trong!");
            return;
        }
        System.out.println("---------------- DANH SACH PHONG BAN ----------------");
        System.out.printf("%-10s | %-20s | %-12s\n", "Ma PB", "Ten PB", "SDT");
        for (int i = 0; i < soLuong; i++) {
            dsPB[i].xuat();
        }
    }

    @Override
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuong; i++) {
            if (dsPB[i].getMaPB().equalsIgnoreCase(ma)) {
                System.out.println("Nhap lai thong tin phong ban:");
                dsPB[i].nhap(sc);
                dsPB[i].setMaPB(ma);
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay phong ban ma: " + ma);
    }

    @Override
    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < soLuong; i++) {
            if (dsPB[i].getMaPB().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay phong ban: " + ma);
            return;
        }
        for (int i = vt; i < soLuong - 1; i++) {
            dsPB[i] = dsPB[i + 1];
        }
        dsPB[--soLuong] = null;
        System.out.println("Xoa thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsPB[i].getMaPB().equalsIgnoreCase(tuKhoa) || 
                dsPB[i].getTenPB().toLowerCase().contains(tuKhoa.toLowerCase())) {
                dsPB[i].xuat();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay phong ban!");
    }
}