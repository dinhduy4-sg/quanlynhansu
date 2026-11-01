
package quanlynhansu;

import java.util.Scanner;

public class DanhSachNghiPhep implements IThaoTac {
    private NghiPhep[] dsNP;
    private int soLuong;

    public DanhSachNghiPhep() {
        dsNP = new NghiPhep[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public NghiPhep[] getDsNP() {
        return dsNP;
    }

    public void themVaoCuoi(NghiPhep np) {
        if (soLuong == dsNP.length) {
            NghiPhep[] mangMoi = new NghiPhep[dsNP.length * 2];
            System.arraycopy(dsNP, 0, mangMoi, 0, soLuong);
            dsNP = mangMoi;
        }

        dsNP[soLuong++] = np;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        NghiPhep np = new NghiPhep();
        np.nhap(sc);
        themVaoCuoi(np);

        System.out.println("Them don nghi phep thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach nghi phep rong!");
            return;
        }

        System.out.println("\n========== DANH SACH NGHI PHEP ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("-----------------------------------------");
            dsNP[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsNP[i].getMaDonNghiPhep().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma don nghi phep!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap thong tin nghi phep moi:");
        dsNP[viTri].nhap(sc);

        // Giu nguyen ma don nghi phep ban dau
        dsNP[viTri].setMaDonNghiPhep(ma);

        System.out.println("Sua don nghi phep thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma don nghi phep!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsNP[i] = dsNP[i + 1];
        }

        dsNP[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa don nghi phep thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            NghiPhep np = dsNP[i];

            if (np.getMaDonNghiPhep().toLowerCase().contains(tuKhoaLower)
                    || np.getNgayNghi().toLowerCase().contains(tuKhoaLower)
                    || np.getLyDo().toLowerCase().contains(tuKhoaLower)
                    || np.getTrangThaiDuyet().toLowerCase().contains(tuKhoaLower)
                    || String.valueOf(np.getSoNgayNghi()).contains(tuKhoaLower)) {

                np.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay thong tin nghi phep!");
        }
    }
}
