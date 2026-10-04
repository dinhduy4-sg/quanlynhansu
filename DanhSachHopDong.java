package quanlynhansu;

import java.util.Scanner;

public class DanhSachHopDong implements IThaoTac {
    private HopDong[] dsHD;
    private int soLuong;

    public DanhSachHopDong() {
        dsHD = new HopDong[10];
        soLuong = 0;
    }

    public int getSoLuong() { return soLuong; }
    public HopDong[] getDsHD() { return dsHD; }

    private void noiRongMang() {
        HopDong[] moi = new HopDong[dsHD.length * 2];
        for (int i = 0; i < soLuong; i++) moi[i] = dsHD[i];
        dsHD = moi;
    }

    public void themVaoCuoi(HopDong hd) {
        if (soLuong == dsHD.length) noiRongMang();
        dsHD[soLuong++] = hd;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        HopDong hd = new HopDong();
        hd.nhap(sc);
        themVaoCuoi(hd);
        System.out.println("Them hop dong thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach hop dong trong!");
            return;
        }
        System.out.println("---------------- DANH SACH HOP DONG ----------------");
        System.out.printf("%-10s | %-10s | %-15s | %-12s | %-12s\n", "Ma HD", "Ma NV", "Loai HD", "Ngay Ky", "Ngay Het Han");
        for (int i = 0; i < soLuong; i++) {
            dsHD[i].xuat();
        }
    }

    @Override
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuong; i++) {
            if (dsHD[i].getMaHD().equalsIgnoreCase(ma)) {
                System.out.println("Nhap lai thong tin hop dong:");
                dsHD[i].nhap(sc);
                dsHD[i].setMaHD(ma);
                System.out.println("Cap nhat hop dong thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay hop dong: " + ma);
    }

    @Override
    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < soLuong; i++) {
            if (dsHD[i].getMaHD().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay hop dong: " + ma);
            return;
        }
        for (int i = vt; i < soLuong - 1; i++) {
            dsHD[i] = dsHD[i + 1];
        }
        dsHD[--soLuong] = null;
        System.out.println("Xoa hop dong thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsHD[i].getMaHD().equalsIgnoreCase(tuKhoa) || dsHD[i].getMaNV().equalsIgnoreCase(tuKhoa)) {
                dsHD[i].xuat();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay hop dong phu hop!");
    }
}