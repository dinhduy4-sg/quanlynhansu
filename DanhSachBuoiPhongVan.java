
package quanlynhansu;

import java.util.Scanner;

public class DanhSachBuoiPhongVan implements IThaoTac {
    private BuoiPhongVan[] dsPV;
    private int soLuong;

    public DanhSachBuoiPhongVan() {
        dsPV = new BuoiPhongVan[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public BuoiPhongVan[] getDsPV() {
        return dsPV;
    }

    public void themVaoCuoi(BuoiPhongVan pv) {
        if (soLuong == dsPV.length) {
            BuoiPhongVan[] mangMoi =
                    new BuoiPhongVan[dsPV.length * 2];

            System.arraycopy(dsPV, 0, mangMoi, 0, soLuong);
            dsPV = mangMoi;
        }

        dsPV[soLuong++] = pv;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        BuoiPhongVan pv = new BuoiPhongVan();
        pv.nhap(sc);
        themVaoCuoi(pv);

        System.out.println("Them buoi phong van thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach buoi phong van rong!");
            return;
        }

        System.out.println("\n========== DANH SACH BUOI PHONG VAN ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("----------------------------------------------");
            dsPV[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPV[i].getMaPhongVan().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma phong van!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin buoi phong van moi:");
        dsPV[viTri].nhap(sc);

        // Giu nguyen ma phong van ban dau
        dsPV[viTri].setMaPhongVan(ma);

        System.out.println("Sua buoi phong van thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma phong van!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsPV[i] = dsPV[i + 1];
        }

        dsPV[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa buoi phong van thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            BuoiPhongVan pv = dsPV[i];

            if (pv.getMaPhongVan().toLowerCase().contains(tuKhoaLower)
                    || pv.getThoiGian().toLowerCase().contains(tuKhoaLower)
                    || pv.getNguoiPhongVan().toLowerCase().contains(tuKhoaLower)
                    || pv.getKetQua().toLowerCase().contains(tuKhoaLower)) {

                pv.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay buoi phong van!");
        }
    }
}
