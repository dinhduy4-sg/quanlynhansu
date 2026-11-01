
package quanlynhansu;

import java.util.Scanner;

public class DanhSachThuong implements IThaoTac {
    private Thuong[] dsThuong;
    private int soLuong;

    public DanhSachThuong() {
        dsThuong = new Thuong[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Thuong[] getDsThuong() {
        return dsThuong;
    }

    public void themVaoCuoi(Thuong t) {
        if (soLuong == dsThuong.length) {
            Thuong[] mangMoi = new Thuong[dsThuong.length * 2];
            System.arraycopy(dsThuong, 0, mangMoi, 0, soLuong);
            dsThuong = mangMoi;
        }
        dsThuong[soLuong++] = t;
    }

    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        Thuong t = new Thuong();
        t.nhap(sc);
        themVaoCuoi(t);
        System.out.println("Them thuong thanh cong!");
    }

    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach thuong rong!");
            return;
        }

        System.out.println("\n========== DANH SACH KHEN THUONG ==========");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("-------------------------------------------");
            dsThuong[i].xuat();
        }
    }

    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsThuong[i].getMaThuong().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma thuong!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin thuong moi:");
        dsThuong[viTri].nhap(sc);
        dsThuong[viTri].setMaThuong(ma);

        System.out.println("Sua thong tin thuong thanh cong!");
    }

    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ma thuong!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsThuong[i] = dsThuong[i + 1];
        }

        dsThuong[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa thuong thanh cong!");
    }

    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            Thuong t = dsThuong[i];

            if (t.getMaThuong().toLowerCase().contains(tuKhoa.toLowerCase())
                    || t.getLyDo().toLowerCase().contains(tuKhoa.toLowerCase())
                    || t.getNgayThuong().toLowerCase().contains(tuKhoa.toLowerCase())) {
                t.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay thong tin thuong!");
        }
    }
}
