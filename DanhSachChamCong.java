package quanlynhansu;

import java.util.Scanner;

public class DanhSachChamCong implements IThaoTac {
    private ChamCong[] dsCC;
    private int soLuong;

    public DanhSachChamCong() {
        dsCC = new ChamCong[10];
        soLuong = 0;
    }

    public int getSoLuong() { return soLuong; }
    public ChamCong[] getDsCC() { return dsCC; }

    private void noiRongMang() {
        ChamCong[] moi = new ChamCong[dsCC.length * 2];
        for (int i = 0; i < soLuong; i++) moi[i] = dsCC[i];
        dsCC = moi;
    }

    public void themVaoCuoi(ChamCong cc) {
        if (soLuong == dsCC.length) noiRongMang();
        dsCC[soLuong++] = cc;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        ChamCong cc = new ChamCong();
        cc.nhap(sc);
        themVaoCuoi(cc);
        System.out.println("Them cham cong thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach cham cong trong!");
            return;
        }
        System.out.println("---------------- DANH SACH CHAM CONG ----------------");
        for (int i = 0; i < soLuong; i++) {
            dsCC[i].xuat();
        }
    }

    @Override
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soLuong; i++) {
            if (dsCC[i].getMaCC().equalsIgnoreCase(ma)) {
                System.out.println("Nhap lai thong tin cham cong:");
                dsCC[i].nhap(sc);
                dsCC[i].setMaCC(ma);
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay ban ghi cham cong: " + ma);
    }

    @Override
    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < soLuong; i++) {
            if (dsCC[i].getMaCC().equalsIgnoreCase(ma)) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Khong tim thay ban ghi: " + ma);
            return;
        }
        for (int i = vt; i < soLuong - 1; i++) {
            dsCC[i] = dsCC[i + 1];
        }
        dsCC[--soLuong] = null;
        System.out.println("Xoa ban ghi cham cong thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsCC[i].getMaCC().equalsIgnoreCase(tuKhoa) || dsCC[i].getMaNV().equalsIgnoreCase(tuKhoa)) {
                dsCC[i].xuat();
                timThay = true;
            }
        }
        if (!timThay) System.out.println("Khong tim thay!");
    }

    public void thongKeTheoThang(int thang) {
        System.out.println("=== THONG KE CHAM CONG THANG " + thang + " ===");
        for (int i = 0; i < soLuong; i++) {
            if (dsCC[i].getThang() == thang) {
                dsCC[i].xuat();
            }
        }
    }
}