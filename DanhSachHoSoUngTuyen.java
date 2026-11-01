
package quanlynhansu;

import java.util.Scanner;

public class DanhSachHoSoUngTuyen implements IThaoTac {
    private HoSoUngTuyen[] dsHS;
    private int soLuong;

    public DanhSachHoSoUngTuyen() {
        dsHS = new HoSoUngTuyen[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public HoSoUngTuyen[] getDsHS() {
        return dsHS;
    }

    public void themVaoCuoi(HoSoUngTuyen hs) {
        if (soLuong == dsHS.length) {
            HoSoUngTuyen[] mangMoi =
                    new HoSoUngTuyen[dsHS.length * 2];

            System.arraycopy(dsHS, 0, mangMoi, 0, soLuong);
            dsHS = mangMoi;
        }

        dsHS[soLuong++] = hs;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        HoSoUngTuyen hs = new HoSoUngTuyen();
        hs.nhap(sc);
        themVaoCuoi(hs);

        System.out.println("Them ho so ung tuyen thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach ho so ung tuyen rong!");
            return;
        }

        System.out.println("\n========== DANH SACH HO SO UNG TUYEN ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("-----------------------------------------------");
            dsHS[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsHS[i].getMaHoSo().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma ho so ung tuyen!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ho so ung tuyen moi:");
        dsHS[viTri].nhap(sc);

        // Giu nguyen ma ho so ban dau
        dsHS[viTri].setMaHoSo(ma);

        System.out.println("Sua ho so ung tuyen thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma ho so ung tuyen!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsHS[i] = dsHS[i + 1];
        }

        dsHS[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa ho so ung tuyen thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            HoSoUngTuyen hs = dsHS[i];

            if (hs.getMaHoSo().toLowerCase().contains(tuKhoaLower)
                    || hs.getUngVien().toLowerCase().contains(tuKhoaLower)
                    || hs.getTinTuyenDung().toLowerCase().contains(tuKhoaLower)
                    || hs.getNgayNop().toLowerCase().contains(tuKhoaLower)
                    || hs.getTrangThai().toLowerCase().contains(tuKhoaLower)) {

                hs.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ho so ung tuyen!");
        }
    }
}
