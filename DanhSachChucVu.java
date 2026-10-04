package quanlynhansu;

import java.util.Scanner;

public class DanhSachChucVu implements IThaoTac {
    private ChucVu[] dsCV;
    private int soLuong;

    public DanhSachChucVu() {
        dsCV = new ChucVu[10];
        soLuong = 0;
    }

    public int getSoLuong() { return soLuong; }
    public ChucVu[] getDsCV() { return dsCV; }

    private void noiRongMang() {
        ChucVu[] moi = new ChucVu[dsCV.length * 2];
        for (int i = 0; i < soLuong; i++) moi[i] = dsCV[i];
        dsCV = moi;
    }

    public void themVaoCuoi(ChucVu cv) {
        if (soLuong == dsCV.length) noiRongMang();
        dsCV[soLuong++] = cv;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        ChucVu cv = new ChucVu();
        cv.nhap(sc);
        themVaoCuoi(cv);
        System.out.println("Them chuc vu thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach chuc vu trong!");
            return;
        }
        System.out.println("---------------- DANH SACH CHUC VU ----------------");
        System.out.printf("%-10s | %-20s | %-10s\n", "Ma CV", "Ten Chuc Vu", "He So PC");
        for (int i = 0; i < soLuong; i++) {
            dsCV[i].xuat();
        }
    }

    @Override
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuong; i++) {
            if (dsCV[i].getMaCV().equalsIgnoreCase(ma)) {
                System.out.println("Nhap lai thong tin chuc vu:");
                dsCV[i].nhap(sc);
                dsCV[i].setMaCV(ma);
                System.out.println("Sua thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay chuc vu ma: " + ma);
    }

    @Override
    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < soLuong; i++) {
            if (dsCV[i].getMaCV().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay ma chuc vu: " + ma);
            return;
        }
        for (int i = vt; i < soLuong - 1; i++) {
            dsCV[i] = dsCV[i + 1];
        }
        dsCV[--soLuong] = null;
        System.out.println("Xoa chuc vu thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsCV[i].getMaCV().equalsIgnoreCase(tuKhoa) || 
                dsCV[i].getTenCV().toLowerCase().contains(tuKhoa.toLowerCase())) {
                dsCV[i].xuat();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay chuc vu!");
    }
}