
package quanlynhansu;

import java.util.Scanner;

public class DanhSachKhoaDaoTao implements IThaoTac {
    private KhoaDaoTao[] dsKDT;
    private int soLuong;

    public DanhSachKhoaDaoTao() {
        dsKDT = new KhoaDaoTao[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public KhoaDaoTao[] getDsKDT() {
        return dsKDT;
    }

    public void themVaoCuoi(KhoaDaoTao khoa) {
        if (soLuong == dsKDT.length) {
            KhoaDaoTao[] mangMoi =
                    new KhoaDaoTao[dsKDT.length * 2];

            System.arraycopy(dsKDT, 0, mangMoi, 0, soLuong);
            dsKDT = mangMoi;
        }

        dsKDT[soLuong++] = khoa;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        KhoaDaoTao khoa = new KhoaDaoTao();
        khoa.nhap(sc);
        themVaoCuoi(khoa);

        System.out.println("Them khoa dao tao thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach khoa dao tao rong!");
            return;
        }

        System.out.println("\n========== DANH SACH KHOA DAO TAO ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("--------------------------------------------");
            dsKDT[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsKDT[i].getMaKhoaHoc().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma khoa hoc!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin khoa dao tao moi:");
        dsKDT[viTri].nhap(sc);

        // Giu nguyen ma khoa hoc ban dau
        dsKDT[viTri].setMaKhoaHoc(ma);

        System.out.println("Sua khoa dao tao thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma khoa hoc!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsKDT[i] = dsKDT[i + 1];
        }

        dsKDT[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa khoa dao tao thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            KhoaDaoTao khoa = dsKDT[i];

            if (khoa.getMaKhoaHoc().toLowerCase().contains(tuKhoaLower)
                    || khoa.getTenKhoaHoc().toLowerCase().contains(tuKhoaLower)
                    || khoa.getThoiGian().toLowerCase().contains(tuKhoaLower)
                    || String.valueOf(khoa.getChiPhi()).contains(tuKhoaLower)) {

                khoa.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay khoa dao tao!");
        }
    }
}
