
package quanlynhansu;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // ==================================================
    // 1. KHAI BÁO 5 DANH SÁCH BAN ĐẦU
    // ==================================================

    static DanhSachNhanVien qlNV = new DanhSachNhanVien();
    static DanhSachChucVu qlCV = new DanhSachChucVu();
    static DanhSachPhongBan qlPB = new DanhSachPhongBan();
    static DanhSachHopDong qlHD = new DanhSachHopDong();
    static DanhSachChamCong qlCC = new DanhSachChamCong();

    // ==================================================
    // 2. KHAI BÁO 15 DANH SÁCH MỚI
    // ==================================================

    static DanhSachHopDongLaoDong qlHDLD =
            new DanhSachHopDongLaoDong();

    static DanhSachCaLamViec qlCa =
            new DanhSachCaLamViec();

    static DanhSachLichLamViec qlLich =
            new DanhSachLichLamViec();

    static DanhSachPhanCongCongViec qlPC =
            new DanhSachPhanCongCongViec();

    static DanhSachKyLuat qlKL =
            new DanhSachKyLuat();

    static DanhSachChiTietLuong qlCTL =
            new DanhSachChiTietLuong();

    static DanhSachThuong qlThuong =
            new DanhSachThuong();

    static DanhSachBaoHiem qlBH =
            new DanhSachBaoHiem();

    static DanhSachNghiPhep qlNP =
            new DanhSachNghiPhep();

    static DanhSachUngVien qlUV =
            new DanhSachUngVien();

    static DanhSachTinTuyenDung qlTTD =
            new DanhSachTinTuyenDung();

    static DanhSachHoSoUngTuyen qlHS =
            new DanhSachHoSoUngTuyen();

    static DanhSachBuoiPhongVan qlPV =
            new DanhSachBuoiPhongVan();

    static DanhSachKhoaDaoTao qlKDT =
            new DanhSachKhoaDaoTao();

    static DanhSachKetQuaDaoTao qlKQDT =
            new DanhSachKetQuaDaoTao();


    // ==================================================
    // 3. HÀM MAIN
    // ==================================================

    public static void main(String[] args) {

        // Đọc dữ liệu từ tất cả các file khi chạy chương trình
        docTatCaFile();

        int chon;

        do {
            menuChinh();

            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {

                // ------------------------------------------
                // 5 MỤC QUẢN LÝ BAN ĐẦU
                // ------------------------------------------

                case 1:
                    menuQuanLy(qlNV, "QUAN LY NHAN VIEN");
                    break;

                case 2:
                    menuQuanLy(qlCV, "QUAN LY CHUC VU");
                    break;

                case 3:
                    menuQuanLy(qlPB, "QUAN LY PHONG BAN");
                    break;

                case 4:
                    menuQuanLy(qlHD, "QUAN LY HOP DONG");
                    break;

                case 5:
                    menuQuanLy(qlCC, "QUAN LY CHAM CONG");
                    break;

                // ------------------------------------------
                // 15 MỤC QUẢN LÝ MỚI
                // ------------------------------------------

                case 6:
                    menuQuanLy(qlHDLD, "QUAN LY HOP DONG LAO DONG");
                    break;

                case 7:
                    menuQuanLy(qlCa, "QUAN LY CA LAM VIEC");
                    break;

                case 8:
                    menuQuanLy(qlLich, "QUAN LY LICH LAM VIEC");
                    break;

                case 9:
                    menuQuanLy(qlPC, "QUAN LY PHAN CONG CONG VIEC");
                    break;

                case 10:
                    menuQuanLy(qlKL, "QUAN LY KY LUAT");
                    break;

                case 11:
                    menuQuanLy(qlCTL, "QUAN LY CHI TIET LUONG");
                    break;

                case 12:
                    menuQuanLy(qlThuong, "QUAN LY KHEN THUONG");
                    break;

                case 13:
                    menuQuanLy(qlBH, "QUAN LY BAO HIEM");
                    break;

                case 14:
                    menuQuanLy(qlNP, "QUAN LY NGHI PHEP");
                    break;

                case 15:
                    menuQuanLy(qlUV, "QUAN LY UNG VIEN");
                    break;

                case 16:
                    menuQuanLy(qlTTD, "QUAN LY TIN TUYEN DUNG");
                    break;

                case 17:
                    menuQuanLy(qlHS, "QUAN LY HO SO UNG TUYEN");
                    break;

                case 18:
                    menuQuanLy(qlPV, "QUAN LY BUOI PHONG VAN");
                    break;

                case 19:
                    menuQuanLy(qlKDT, "QUAN LY KHOA DAO TAO");
                    break;

                case 20:
                    menuQuanLy(qlKQDT, "QUAN LY KET QUA DAO TAO");
                    break;

                // ------------------------------------------
                // LƯU DỮ LIỆU
                // ------------------------------------------

                case 21:
                    ghiTatCaFile();
                    break;

                // ------------------------------------------
                // THOÁT CHƯƠNG TRÌNH
                // ------------------------------------------

                case 0:
                    ghiTatCaFile();
                    System.out.println("Da luu du lieu!");
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }


    // ==================================================
    // 4. MENU CHÍNH
    // ==================================================

    public static void menuChinh() {

        System.out.println("\n==============================================");
        System.out.println("       CHUONG TRINH QUAN LY NHAN SU");
        System.out.println("==============================================");

        System.out.println("1.  Quan ly nhan vien");
        System.out.println("2.  Quan ly chuc vu");
        System.out.println("3.  Quan ly phong ban");
        System.out.println("4.  Quan ly hop dong");
        System.out.println("5.  Quan ly cham cong");

        System.out.println("----------------------------------------------");

        System.out.println("6.  Quan ly hop dong lao dong");
        System.out.println("7.  Quan ly ca lam viec");
        System.out.println("8.  Quan ly lich lam viec");
        System.out.println("9.  Quan ly phan cong cong viec");
        System.out.println("10. Quan ly ky luat");
        System.out.println("11. Quan ly chi tiet luong");
        System.out.println("12. Quan ly thuong");
        System.out.println("13. Quan ly bao hiem");
        System.out.println("14. Quan ly nghi phep");
        System.out.println("15. Quan ly ung vien");
        System.out.println("16. Quan ly tin tuyen dung");
        System.out.println("17. Quan ly ho so ung tuyen");
        System.out.println("18. Quan ly buoi phong van");
        System.out.println("19. Quan ly khoa dao tao");
        System.out.println("20. Quan ly ket qua dao tao");

        System.out.println("----------------------------------------------");

        System.out.println("21. Luu tat ca du lieu");
        System.out.println("0.  Luu va thoat chuong trinh");

        System.out.println("==============================================");
    }


    // ==================================================
    // 5. MENU QUẢN LÝ DÙNG CHUNG CHO CÁC DANH SÁCH
    // ==================================================

    public static void menuQuanLy(IThaoTac ds, String ten) {

        int chon;

        do {
            System.out.println("\n==============================================");
            System.out.println("       " + ten);
            System.out.println("==============================================");

            System.out.println("1. Them");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("5. Tim kiem");
            System.out.println("0. Quay lai menu chinh");

            System.out.println("==============================================");

            chon = nhapSoNguyen("Nhap lua chon: ");

            switch (chon) {

                case 1:
                    ds.them();
                    break;

                case 2:
                    ds.xuat();
                    break;

                case 3:
                    System.out.print("Nhap ma can sua: ");
                    String maSua = sc.nextLine();
                    ds.sua(maSua);
                    break;

                case 4:
                    System.out.print("Nhap ma can xoa: ");
                    String maXoa = sc.nextLine();
                    ds.xoa(maXoa);
                    break;

                case 5:
                    System.out.print("Nhap tu khoa can tim: ");
                    String tuKhoa = sc.nextLine();
                    ds.timKiem(tuKhoa);
                    break;

                case 0:
                    System.out.println("Quay lai menu chinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }


    // ==================================================
    // 6. HÀM NHẬP SỐ NGUYÊN
    // ==================================================

    public static int nhapSoNguyen(String thongBao) {

        while (true) {
            try {
                System.out.print(thongBao);
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }


    // ==================================================
    // 7. ĐỌC TẤT CẢ DỮ LIỆU TỪ FILE
    // ==================================================

    public static void docTatCaFile() {

        System.out.println("\n========== DOC DU LIEU TU FILE ==========");

        // 5 danh sách ban đầu
        FileNhanVien.docFile(qlNV, "nhanvien.txt");
        FileChucVu.docFile(qlCV, "chucvu.txt");
        FilePhongBan.docFile(qlPB, "phongban.txt");
        FileHopDong.docFile(qlHD, "hopdong.txt");
        FileChamCong.docFile(qlCC, "chamcong.txt");

        // 15 danh sách mới
        FileHopDongLaoDong.docFile(qlHDLD, "hopdonglaodong.txt");
        FileCaLamViec.docFile(qlCa, "calamviec.txt");
        FileLichLamViec.docFile(qlLich, "lichlamviec.txt");
        FilePhanCongCongViec.docFile(qlPC, "phancongcongviec.txt");
        FileKyLuat.docFile(qlKL, "kyluat.txt");
        FileChiTietLuong.docFile(qlCTL, "chitietluong.txt");
        FileThuong.docFile(qlThuong, "thuong.txt");
        FileBaoHiem.docFile(qlBH, "baohiem.txt");
        FileNghiPhep.docFile(qlNP, "nghiphep.txt");
        FileUngVien.docFile(qlUV, "ungvien.txt");
        FileTinTuyenDung.docFile(qlTTD, "tintuyendung.txt");
        FileHoSoUngTuyen.docFile(qlHS, "hosoungtuyen.txt");
        FileBuoiPhongVan.docFile(qlPV, "buoiphongvan.txt");
        FileKhoaDaoTao.docFile(qlKDT, "khoadaotao.txt");
        FileKetQuaDaoTao.docFile(qlKQDT, "ketquadaotao.txt");

        System.out.println("========== DOC FILE HOAN TAT ==========");
    }


    // ==================================================
    // 8. GHI TẤT CẢ DỮ LIỆU VÀO FILE
    // ==================================================

    public static void ghiTatCaFile() {

        System.out.println("\n========== LUU DU LIEU VAO FILE ==========");

        // 5 danh sách ban đầu
        FileNhanVien.ghiFile(qlNV, "nhanvien.txt");
        FileChucVu.ghiFile(qlCV, "chucvu.txt");
        FilePhongBan.ghiFile(qlPB, "phongban.txt");
        FileHopDong.ghiFile(qlHD, "hopdong.txt");
        FileChamCong.ghiFile(qlCC, "chamcong.txt");

        // 15 danh sách mới
        FileHopDongLaoDong.ghiFile(qlHDLD, "hopdonglaodong.txt");
        FileCaLamViec.ghiFile(qlCa, "calamviec.txt");
        FileLichLamViec.ghiFile(qlLich, "lichlamviec.txt");
        FilePhanCongCongViec.ghiFile(qlPC, "phancongcongviec.txt");
        FileKyLuat.ghiFile(qlKL, "kyluat.txt");
        FileChiTietLuong.ghiFile(qlCTL, "chitietluong.txt");
        FileThuong.ghiFile(qlThuong, "thuong.txt");
        FileBaoHiem.ghiFile(qlBH, "baohiem.txt");
        FileNghiPhep.ghiFile(qlNP, "nghiphep.txt");
        FileUngVien.ghiFile(qlUV, "ungvien.txt");
        FileTinTuyenDung.ghiFile(qlTTD, "tintuyendung.txt");
        FileHoSoUngTuyen.ghiFile(qlHS, "hosoungtuyen.txt");
        FileBuoiPhongVan.ghiFile(qlPV, "buoiphongvan.txt");
        FileKhoaDaoTao.ghiFile(qlKDT, "khoadaotao.txt");
        FileKetQuaDaoTao.ghiFile(qlKQDT, "ketquadaotao.txt");

        System.out.println("========== LUU FILE HOAN TAT ==========");
    }
}
