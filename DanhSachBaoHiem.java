
package quanlynhansu;

import java.util.Scanner;

public class DanhSachBaoHiem implements IThaoTac {
    private BaoHiem[] dsBH;
    private int soLuong;

    public DanhSachBaoHiem() {
        dsBH = new BaoHiem[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public BaoHiem[] getDsBH() {
        return dsBH;
    }

    public void themVaoCuoi(BaoHiem bh) {
        if (soLuong == dsBH.length) {
            BaoHiem[] mangMoi = new BaoHiem[dsBH.length * 2];
            System.arraycopy(dsBH, 0, mangMoi, 0, soLuong);
            dsBH = mangMoi;
        }
        dsBH[soLuong++] = bh;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        BaoHiem bh = new BaoHiem();
        bh.nhap(sc);
        themVaoCuoi(bh);
        System.out.println("Them bao hiem thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach bao hiem rong!");
            return;
        }

        System.out.println("\n========== DANH SACH BAO HIEM ==========");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("----------------------------------------");
            dsBH[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsBH[i].getMaBaoHiem().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma bao hiem!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin bao hiem moi:");
        dsBH[viTri].nhap(sc);
        dsBH[viTri].setMaBaoHiem(ma);

        System.out.println("Sua thong tin bao hiem thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma bao hiem!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsBH[i] = dsBH[i + 1];
        }

        dsBH[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa bao hiem thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            BaoHiem bh = dsBH[i];

            if (bh.getMaBaoHiem().toLowerCase().contains(tuKhoa.toLowerCase())
                    || bh.getLoaiBaoHiem().toLowerCase().contains(tuKhoa.toLowerCase())
                    || bh.getNgayBatDau().toLowerCase().contains(tuKhoa.toLowerCase())) {
                bh.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay thong tin bao hiem!");
        }
    }
}
