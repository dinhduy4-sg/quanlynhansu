
package quanlynhansu;

import java.util.Scanner;

public class DanhSachUngVien implements IThaoTac {
    private UngVien[] dsUV;
    private int soLuong;

    public DanhSachUngVien() {
        dsUV = new UngVien[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public UngVien[] getDsUV() {
        return dsUV;
    }

    public void themVaoCuoi(UngVien uv) {
        if (soLuong == dsUV.length) {
            UngVien[] mangMoi = new UngVien[dsUV.length * 2];
            System.arraycopy(dsUV, 0, mangMoi, 0, soLuong);
            dsUV = mangMoi;
        }

        dsUV[soLuong++] = uv;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        UngVien uv = new UngVien();
        uv.nhap(sc);
        themVaoCuoi(uv);
        System.out.println("Them ung vien thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach ung vien rong!");
            return;
        }

        System.out.println("\n========== DANH SACH UNG VIEN ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("----------------------------------------");
            dsUV[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsUV[i].getMaUngVien().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma ung vien!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ung vien moi:");
        dsUV[viTri].nhap(sc);

        // Giu nguyen ma ung vien ban dau
        dsUV[viTri].setMaUngVien(ma);

        System.out.println("Sua thong tin ung vien thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma ung vien!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsUV[i] = dsUV[i + 1];
        }

        dsUV[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa ung vien thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            UngVien uv = dsUV[i];

            if (uv.getMaUngVien().toLowerCase().contains(tuKhoaLower)
                    || uv.getHoTen().toLowerCase().contains(tuKhoaLower)
                    || uv.getEmail().toLowerCase().contains(tuKhoaLower)
                    || uv.getSoDienThoai().toLowerCase().contains(tuKhoaLower)
                    || uv.getViTriUngTuyen().toLowerCase().contains(tuKhoaLower)) {

                uv.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ung vien!");
        }
    }
}
