
package quanlynhansu;

import java.util.Scanner;

public class DanhSachKyLuat implements IThaoTac {
    private KyLuat[] dsKL;
    private int soLuong;

    public DanhSachKyLuat() {
        dsKL = new KyLuat[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public KyLuat[] getDsKL() {
        return dsKL;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        KyLuat[] mangMoi = new KyLuat[dsKL.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsKL[i];
        }

        dsKL = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(KyLuat kl) {
        if (soLuong == dsKL.length) {
            noiRongMang();
        }

        dsKL[soLuong] = kl;
        soLuong++;
    }

    // Them quyet dinh ky luat
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        KyLuat kl = new KyLuat();

        kl.nhap(sc);
        themVaoCuoi(kl);

        System.out.println("Them quyet dinh ky luat thanh cong!");
    }

    // Xuat danh sach ky luat
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach ky luat rong!");
            return;
        }

        System.out.printf("%-15s | %-25s | %-30s | %-15s\n",
                "Ma quyet dinh", "Hinh thuc ky luat",
                "Ly do", "Ngay quyet dinh");

        for (int i = 0; i < soLuong; i++) {
            dsKL[i].xuat();
        }
    }

    // Tim vi tri theo ma quyet dinh
    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsKL[i].getMaQuyetDinh().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // Sua quyet dinh ky luat
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay quyet dinh can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin ky luat moi:");

        String maCu = dsKL[viTri].getMaQuyetDinh();

        dsKL[viTri].nhap(sc);

        // Giu nguyen ma quyet dinh ban dau
        dsKL[viTri].setMaQuyetDinh(maCu);

        System.out.println("Sua quyet dinh ky luat thanh cong!");
    }

    // Xoa quyet dinh ky luat
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay quyet dinh can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsKL[i] = dsKL[i + 1];
        }

        dsKL[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa quyet dinh ky luat thanh cong!");
    }

    // Tim kiem quyet dinh ky luat
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            KyLuat kl = dsKL[i];

            if (kl.getMaQuyetDinh().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || kl.getHinhThucKyLuat().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || kl.getLyDo().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                kl.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay quyet dinh ky luat phu hop!");
        }
    }
}
