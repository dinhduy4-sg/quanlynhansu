
package quanlynhansu;

import java.util.Scanner;

public class DanhSachKetQuaDaoTao implements IThaoTac {

    private KetQuaDaoTao[] dsKQDT;
    private int soLuong;

    // Constructor
    public DanhSachKetQuaDaoTao() {
        dsKQDT = new KetQuaDaoTao[10];
        soLuong = 0;
    }

    // Getter
    public KetQuaDaoTao[] getDsKQDT() {
        return dsKQDT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Hàm tăng kích thước mảng
    private void noiRongMang() {
        KetQuaDaoTao[] temp = new KetQuaDaoTao[dsKQDT.length * 2];

        for (int i = 0; i < soLuong; i++) {
            temp[i] = dsKQDT[i];
        }

        dsKQDT = temp;
    }

    // Thêm một kết quả đào tạo vào cuối danh sách
    public void themVaoCuoi(KetQuaDaoTao kqdt) {
        if (soLuong == dsKQDT.length) {
            noiRongMang();
        }

        dsKQDT[soLuong] = kqdt;
        soLuong++;
    }

    // Nhập danh sách kết quả đào tạo
    public void them() {
        Scanner sc = new Scanner(System.in);

        if (soLuong == dsKQDT.length) {
            noiRongMang();
        }

        KetQuaDaoTao kqdt = new KetQuaDaoTao();
        kqdt.nhap(sc);

        dsKQDT[soLuong] = kqdt;
        soLuong++;

        System.out.println("Them ket qua dao tao thanh cong!");
    }

    // Xuất danh sách kết quả đào tạo
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach ket qua dao tao rong!");
            return;
        }

        System.out.println("\n========== DANH SACH KET QUA DAO TAO ==========");

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nKet qua dao tao thu " + (i + 1) + ":");
            dsKQDT[i].xuat();
        }
    }

    // Sửa kết quả đào tạo theo mã nhân viên và mã khóa học
    public void sua(String ma) {
        Scanner sc = new Scanner(System.in);
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            String maKQDT = dsKQDT[i].getMaNV()
                    + "_" + dsKQDT[i].getMaKhoaHoc();

            if (maKQDT.equalsIgnoreCase(ma)) {
                System.out.println("Nhap thong tin ket qua dao tao moi:");

                String maNVCu = dsKQDT[i].getMaNV();
                String maKhoaHocCu = dsKQDT[i].getMaKhoaHoc();

                dsKQDT[i].nhap(sc);

                dsKQDT[i].setMaNV(maNVCu);
                dsKQDT[i].setMaKhoaHoc(maKhoaHocCu);

                System.out.println("Sua ket qua dao tao thanh cong!");
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ket qua dao tao!");
        }
    }

    // Xóa kết quả đào tạo
    public void xoa(String ma) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            String maKQDT = dsKQDT[i].getMaNV()
                    + "_" + dsKQDT[i].getMaKhoaHoc();

            if (maKQDT.equalsIgnoreCase(ma)) {

                for (int j = i; j < soLuong - 1; j++) {
                    dsKQDT[j] = dsKQDT[j + 1];
                }

                dsKQDT[soLuong - 1] = null;
                soLuong--;

                System.out.println("Xoa ket qua dao tao thanh cong!");
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ket qua dao tao!");
        }
    }

    // Tìm kiếm kết quả đào tạo
    public void timKiem(String tuKhoa) {
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            KetQuaDaoTao kqdt = dsKQDT[i];

            if (kqdt.getMaNV().toLowerCase().contains(tuKhoa.toLowerCase())
                    || kqdt.getMaKhoaHoc().toLowerCase().contains(tuKhoa.toLowerCase())
                    || kqdt.getXepLoai().toLowerCase().contains(tuKhoa.toLowerCase())) {

                System.out.println("\nKet qua dao tao tai vi tri " + (i + 1) + ":");
                kqdt.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ket qua dao tao!");
        }
    }
}
