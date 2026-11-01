
package quanlynhansu;

import java.util.Scanner;

public class DanhSachHopDongLaoDong implements IThaoTac {
    private HopDongLaoDong[] dsHDLD;
    private int soLuong;

    public DanhSachHopDongLaoDong() {
        dsHDLD = new HopDongLaoDong[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public HopDongLaoDong[] getDsHDLD() {
        return dsHDLD;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        HopDongLaoDong[] mangMoi =
                new HopDongLaoDong[dsHDLD.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsHDLD[i];
        }

        dsHDLD = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(HopDongLaoDong hd) {
        if (soLuong == dsHDLD.length) {
            noiRongMang();
        }

        dsHDLD[soLuong] = hd;
        soLuong++;
    }

    // Them hop dong lao dong
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        HopDongLaoDong hd = new HopDongLaoDong();

        hd.nhap(sc);
        themVaoCuoi(hd);

        System.out.println("Them hop dong lao dong thanh cong!");
    }

    // Xuat danh sach hop dong lao dong
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach hop dong lao dong rong!");
            return;
        }

        System.out.printf("%-15s | %-15s | %-15s | %-20s\n",
                "Ma hop dong", "Ngay ky", "Ngay het han", "Loai hop dong");

        for (int i = 0; i < soLuong; i++) {
            dsHDLD[i].xuat();
        }
    }

    // Tim vi tri hop dong theo ma
    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsHDLD[i].getMaHopDong().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // Sua hop dong lao dong
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay hop dong can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin hop dong moi:");

        String maCu = dsHDLD[viTri].getMaHopDong();

        dsHDLD[viTri].nhap(sc);

        // Giu nguyen ma hop dong ban dau
        dsHDLD[viTri].setMaHopDong(maCu);

        System.out.println("Sua hop dong lao dong thanh cong!");
    }

    // Xoa hop dong lao dong
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay hop dong can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsHDLD[i] = dsHDLD[i + 1];
        }

        dsHDLD[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa hop dong lao dong thanh cong!");
    }

    // Tim kiem hop dong lao dong
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            HopDongLaoDong hd = dsHDLD[i];

            if (hd.getMaHopDong().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || hd.getLoaiHopDong().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                hd.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay hop dong phu hop!");
        }
    }
}
