
package quanlynhansu;

import java.util.Scanner;

public class DanhSachPhanCongCongViec implements IThaoTac {
    private PhanCongCongViec[] dsPC;
    private int soLuong;

    public DanhSachPhanCongCongViec() {
        dsPC = new PhanCongCongViec[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public PhanCongCongViec[] getDsPC() {
        return dsPC;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        PhanCongCongViec[] mangMoi =
                new PhanCongCongViec[dsPC.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsPC[i];
        }

        dsPC = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(PhanCongCongViec pc) {
        if (soLuong == dsPC.length) {
            noiRongMang();
        }

        dsPC[soLuong] = pc;
        soLuong++;
    }

    // Them phan cong cong viec
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        PhanCongCongViec pc = new PhanCongCongViec();

        pc.nhap(sc);
        themVaoCuoi(pc);

        System.out.println("Them phan cong cong viec thanh cong!");
    }

    // Xuat danh sach phan cong cong viec
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach phan cong cong viec rong!");
            return;
        }

        System.out.printf("%-15s | %-30s | %-15s | %-20s\n",
                "Ma phan cong", "Noi dung cong viec",
                "Thoi han", "Trang thai");

        for (int i = 0; i < soLuong; i++) {
            dsPC[i].xuat();
        }
    }

    // Tim vi tri theo ma phan cong
    public int timViTriTheoMa(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPC[i].getMaPhanCong().equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // Sua phan cong cong viec
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay phan cong can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin phan cong moi:");

        String maCu = dsPC[viTri].getMaPhanCong();

        dsPC[viTri].nhap(sc);

        // Giu nguyen ma phan cong ban dau
        dsPC[viTri].setMaPhanCong(maCu);

        System.out.println("Sua phan cong cong viec thanh cong!");
    }

    // Xoa phan cong cong viec
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoMa(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay phan cong can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsPC[i] = dsPC[i + 1];
        }

        dsPC[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa phan cong cong viec thanh cong!");
    }

    // Tim kiem phan cong cong viec
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            PhanCongCongViec pc = dsPC[i];

            if (pc.getMaPhanCong().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || pc.getNoiDungCongViec().toLowerCase()
                    .contains(tuKhoa.toLowerCase())
                    || pc.getTrangThai().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {

                pc.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay phan cong phu hop!");
        }
    }
}
