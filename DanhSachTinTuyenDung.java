
package quanlynhansu;

import java.util.Scanner;

public class DanhSachTinTuyenDung implements IThaoTac {
    private TinTuyenDung[] dsTTD;
    private int soLuong;

    public DanhSachTinTuyenDung() {
        dsTTD = new TinTuyenDung[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public TinTuyenDung[] getDsTTD() {
        return dsTTD;
    }

    public void themVaoCuoi(TinTuyenDung tin) {
        if (soLuong == dsTTD.length) {
            TinTuyenDung[] mangMoi =
                    new TinTuyenDung[dsTTD.length * 2];

            System.arraycopy(dsTTD, 0, mangMoi, 0, soLuong);
            dsTTD = mangMoi;
        }

        dsTTD[soLuong++] = tin;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        TinTuyenDung tin = new TinTuyenDung();
        tin.nhap(sc);
        themVaoCuoi(tin);

        System.out.println("Them tin tuyen dung thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach tin tuyen dung rong!");
            return;
        }

        System.out.println("\n========== DANH SACH TIN TUYEN DUNG ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("----------------------------------------------");
            dsTTD[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsTTD[i].getMaTin().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma tin tuyen dung!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin tin tuyen dung moi:");
        dsTTD[viTri].nhap(sc);

        // Giu nguyen ma tin ban dau
        dsTTD[viTri].setMaTin(ma);

        System.out.println("Sua tin tuyen dung thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma tin tuyen dung!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsTTD[i] = dsTTD[i + 1];
        }

        dsTTD[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa tin tuyen dung thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            TinTuyenDung tin = dsTTD[i];

            if (tin.getMaTin().toLowerCase().contains(tuKhoaLower)
                    || tin.getViTri().toLowerCase().contains(tuKhoaLower)
                    || tin.getYeuCau().toLowerCase().contains(tuKhoaLower)
                    || tin.getHanNop().toLowerCase().contains(tuKhoaLower)
                    || String.valueOf(tin.getMucLuong()).contains(tuKhoaLower)) {

                tin.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay tin tuyen dung!");
        }
    }
}
