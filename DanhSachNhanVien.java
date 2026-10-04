package quanlynhansu;

import java.util.Scanner;

public class DanhSachNhanVien implements IThaoTac {
    private NhanVien[] dsNV;
    private int soLuong;

    public DanhSachNhanVien() {
        dsNV = new NhanVien[10];
        soLuong = 0;
    }

    public int getSoLuong() { return soLuong; }
    public NhanVien[] getDsNV() { return dsNV; }

    private void noiRongMang() {
        NhanVien[] moi = new NhanVien[dsNV.length * 2];
        for (int i = 0; i < soLuong; i++) {
            moi[i] = dsNV[i];
        }
        dsNV = moi;
    }

    public void themVaoCuoi(NhanVien nv) {
        if (soLuong == dsNV.length) {
            noiRongMang();
        }
        dsNV[soLuong++] = nv;
    }

    public void nhapNPhanTu(Scanner sc) {
        System.out.print("Nhap so luong nhan vien ban dau: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhan vien thu " + (i + 1) + ":");
            System.out.println("Chon loai: 1. Chinh thuc | 2. Thoi vu");
            int chon = Integer.parseInt(sc.nextLine());
            NhanVien nv;
            if (chon == 1) {
                nv = new NhanVienChinhThuc();
            } else {
                nv = new NhanVienThoiVu();
            }
            nv.nhap(sc);
            themVaoCuoi(nv);
        }
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon loai nhan vien can them: 1. Chinh thuc | 2. Thoi vu");
        int chon = Integer.parseInt(sc.nextLine());
        NhanVien nv = (chon == 1) ? new NhanVienChinhThuc() : new NhanVienThoiVu();
        nv.nhap(sc);
        themVaoCuoi(nv);
        System.out.println("Them thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach nhan vien trong!");
            return;
        }
        System.out.println("-------------------------------- DANH SACH NHAN VIEN --------------------------------");
        for (int i = 0; i < soLuong; i++) {
            // Goi tinhLuong va xuat da hinh theo tung loai nhan vien
            dsNV[i].xuat();
        }
    }

    @Override
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        int vt = timViTriTheoMa(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay nhan vien co ma: " + ma);
            return;
        }
        System.out.println("Nhap thong tin moi cho nhan vien " + ma + ":");
        dsNV[vt].nhap(sc);
        dsNV[vt].setMaNV(ma); // giu nguyen ma
        System.out.println("Cap nhat thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int vt = timViTriTheoMa(ma);
        if (vt == -1) {
            System.out.println("Khong tim thay nhan vien ma: " + ma);
            return;
        }
        for (int i = vt; i < soLuong - 1; i++) {
            dsNV[i] = dsNV[i + 1];
        }
        dsNV[--soLuong] = null;
        System.out.println("Xoa thanh cong nhan vien: " + ma);
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        System.out.println("Ket qua tim kiem theo tu khoa: " + tuKhoa);
        for (int i = 0; i < soLuong; i++) {
            if (dsNV[i].getMaNV().equalsIgnoreCase(tuKhoa) || 
                dsNV[i].getHoTen().toLowerCase().contains(tuKhoa.toLowerCase())) {
                dsNV[i].xuat();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Khong co nhan vien nao phu hop!");
        }
    }

    public void thongKe() {
        int ct = 0, tv = 0;
        double tongLuong = 0;
        for (int i = 0; i < soLuong; i++) {
            tongLuong += dsNV[i].tinhLuong();
            if (dsNV[i] instanceof NhanVienChinhThuc) ct++;
            else tv++;
        }
        System.out.println("=== THONG KE NHAN VIEN ===");
        System.out.println("- Nhan vien chinh thuc: " + ct);
        System.out.println("- Nhan vien thoi vu: " + tv);
        System.out.println("- Tong luong can chi tra: " + tongLuong);
    }
}