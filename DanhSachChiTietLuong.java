
package quanlynhansu;

import java.util.Scanner;

public class DanhSachChiTietLuong implements IThaoTac {
    private ChiTietLuong[] dsCTL;
    private int soLuong;

    public DanhSachChiTietLuong() {
        dsCTL = new ChiTietLuong[10];
        soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public ChiTietLuong[] getDsCTL() {
        return dsCTL;
    }

    // Tang kich thuoc mang khi day
    private void noiRongMang() {
        ChiTietLuong[] mangMoi =
                new ChiTietLuong[dsCTL.length * 2];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = dsCTL[i];
        }

        dsCTL = mangMoi;
    }

    // Them vao cuoi danh sach
    public void themVaoCuoi(ChiTietLuong ctl) {
        if (soLuong == dsCTL.length) {
            noiRongMang();
        }

        dsCTL[soLuong] = ctl;
        soLuong++;
    }

    // Them chi tiet luong
    @Override
    public void them() {
        Scanner sc = new Scanner(System.in);
        ChiTietLuong ctl = new ChiTietLuong();

        ctl.nhap(sc);
        themVaoCuoi(ctl);

        System.out.println("Them chi tiet luong thanh cong!");
    }

    // Xuat danh sach chi tiet luong
    @Override
    public void xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach chi tiet luong rong!");
            return;
        }

        System.out.printf(
                "%-15s | %-15s | %-15s | %-15s | %-15s | %-18s\n",
                "Luong co ban", "Phu cap", "Tien thuong",
                "Tien phat", "Khau tru", "Luong thuc nhan"
        );

        for (int i = 0; i < soLuong; i++) {
            dsCTL[i].xuat();
        }
    }

    // Tim vi tri theo luong co ban
    public int timViTriTheoLuongCoBan(String ma) {
        try {
            double luong = Double.parseDouble(ma);

            for (int i = 0; i < soLuong; i++) {
                if (Double.compare(
                        dsCTL[i].getLuongCoBan(), luong) == 0) {
                    return i;
                }
            }
        } catch (NumberFormatException e) {
            return -1;
        }

        return -1;
    }

    // Sua chi tiet luong
    @Override
    public void sua(String ma) {
        int viTri = timViTriTheoLuongCoBan(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay chi tiet luong can sua!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin chi tiet luong moi:");

        dsCTL[viTri].nhap(sc);

        System.out.println("Sua chi tiet luong thanh cong!");
    }

    // Xoa chi tiet luong
    @Override
    public void xoa(String ma) {
        int viTri = timViTriTheoLuongCoBan(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay chi tiet luong can xoa!");
            return;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            dsCTL[i] = dsCTL[i + 1];
        }

        dsCTL[soLuong - 1] = null;
        soLuong--;

        System.out.println("Xoa chi tiet luong thanh cong!");
    }

    // Tim kiem chi tiet luong
    @Override
    public void timKiem(String tuKhoa) {
        boolean timThay = false;
        String tuKhoaLower = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {
            ChiTietLuong ctl = dsCTL[i];

            if (String.valueOf(ctl.getLuongCoBan())
                    .contains(tuKhoaLower)
                    || String.valueOf(ctl.getPhuCap())
                    .contains(tuKhoaLower)
                    || String.valueOf(ctl.getTienThuong())
                    .contains(tuKhoaLower)
                    || String.valueOf(ctl.getTienPhat())
                    .contains(tuKhoaLower)
                    || String.valueOf(ctl.getKhauTru())
                    .contains(tuKhoaLower)) {

                ctl.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay chi tiet luong phu hop!");
        }
    }
}
