
package quanlynhansu;

import java.util.Scanner;

public class DanhSachLichLamViec implements IThaoTac {
    private LichLamViec[] dsLich;
    private int soLuong;

    public DanhSachLichLamViec() {
        dsLich = new LichLamViec[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public LichLamViec[] getDsLich() {
        return dsLich;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        LichLamViec[] mangMoi =
                new LichLamViec[dsLich.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsLich[i];
        }

        dsLich = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(LichLamViec lich) {
        if (soLuong == dsLich.length) {
            noiRongMang();
        }

        dsLich[soLuong] = lich;
        soLuong++;
    }

    // Them lich lam viec
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        LichLamViec lich = new LichLamViec();

        lich.nhap(sc);
        themVaoCuoi(lich);

        System.out.println("Them lich lam viec thanh cong!");
    }

    // Xuat danh sach lich lam viec
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach lich lam viec rong!");
            return;
        }

        System.out.printf("%-10s | %-15s | %-10s | %-10s\n",
                "Ma lich", "Ngay lam", "Ma ca", "Ma nhan vien");

        for (int i = 0; i < soLuong; i++) {
            dsLich[i].xuat();
        }
    }

    // Tim vi tri lich lam viec theo ma
    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsLich[i].getMaLich().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // Sua lich lam viec
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay lich lam viec can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin lich lam viec moi:");

        String maCu = dsLich[viTri].getMaLich();

        dsLich[viTri].nhap(sc);

        // Giu nguyen ma lich ban dau
        dsLich[viTri].setMaLich(maCu);

        System.out.println("Sua lich lam viec thanh cong!");
    }

    // Xoa lich lam viec
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay lich lam viec can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsLich[i] = dsLich[i + 1];
        }

        dsLich[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa lich lam viec thanh cong!");
    }

    // Tim kiem lich lam viec
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            LichLamViec lich = dsLich[i];

            if (lich.getMaLich().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || lich.getMaCa().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || lich.getMaNV().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                lich.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay lich lam viec phu hop!");
        }
    }
}
