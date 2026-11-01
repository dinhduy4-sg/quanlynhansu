
package quanlynhansu;

import java.util.Scanner;

public class DanhSachCaLamViec implements IThaoTac {
    private CaLamViec[] dsCa;
    private int soLuong;

    public DanhSachCaLamViec() {
        dsCa = new CaLamViec[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public CaLamViec[] getDsCa() {
        return dsCa;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        CaLamViec[] mangMoi =
                new CaLamViec[dsCa.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsCa[i];
        }

        dsCa = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(CaLamViec ca) {
        if (soLuong == dsCa.length) {
            noiRongMang();
        }

        dsCa[soLuong] = ca;
        soLuong++;
    }

    // Them ca lam viec
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        CaLamViec ca = new CaLamViec();

        ca.nhap(sc);
        themVaoCuoi(ca);

        System.out.println("Them ca lam viec thanh cong!");
    }

    // Xuat danh sach ca lam viec
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach ca lam viec rong!");
            return;
        }

        System.out.printf("%-10s | %-20s | %-15s | %-15s\n",
                "Ma ca", "Ten ca", "Gio bat dau", "Gio ket thuc");

        for (int i = 0; i < soLuong; i++) {
            dsCa[i].xuat();
        }
    }

    // Tim vi tri ca lam viec theo ma
    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCa[i].getMaCa().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // Sua ca lam viec
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ca lam viec can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ca lam viec moi:");

        String maCu = dsCa[viTri].getMaCa();

        dsCa[viTri].nhap(sc);

        // Giu nguyen ma ca ban dau
        dsCa[viTri].setMaCa(maCu);

        System.out.println("Sua ca lam viec thanh cong!");
    }

    // Xoa ca lam viec
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay ca lam viec can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsCa[i] = dsCa[i + 1];
        }

        dsCa[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa ca lam viec thanh cong!");
    }

    // Tim kiem ca lam viec
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            CaLamViec ca = dsCa[i];

            if (ca.getMaCa().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || ca.getTenCa().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                ca.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ca lam viec phu hop!");
        }
    }
}
