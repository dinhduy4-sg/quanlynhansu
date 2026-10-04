package quanlynhansu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo các danh sách
        DanhSachNhanVien qlNV = new DanhSachNhanVien();
        DanhSachChucVu qlCV = new DanhSachChucVu();
        DanhSachPhongBan qlPB = new DanhSachPhongBan();
        DanhSachHopDong qlHD = new DanhSachHopDong();
        DanhSachChamCong qlCC = new DanhSachChamCong();

        // Tự động tải dữ liệu từ file khi khởi động chương trình
        FileNhanVien.docFile(qlNV, "nhanvien.txt");
        FileChucVu.docFile(qlCV, "chucvu.txt");
        FilePhongBan.docFile(qlPB, "phongban.txt");
        FileHopDong.docFile(qlHD, "hopdong.txt");
        FileChamCong.docFile(qlCC, "chamcong.txt");

        while (true) {
            System.out.println("\n================ HE THONG QUAN LY NHAN SU ================");
            System.out.println("1. Quan ly Nhan vien (Thanh vien 1 & 2)");
            System.out.println("2. Quan ly Chuc vu (Thanh vien 2)");
            System.out.println("3. Quan ly Phong ban (Thanh vien 3)");
            System.out.println("4. Quan ly Hop dong (Thanh vien 4)");
            System.out.println("5. Quan ly Cham cong (Thanh vien 5)");
            System.out.println("6. Luu tat ca du lieu ra file text");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Moi ban chon (0-6): ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    menuNhanVien(qlNV, sc);
                    break;
                case 2:
                    menuChucVu(qlCV, sc);
                    break;
                case 3:
                    menuPhongBan(qlPB, sc);
                    break;
                case 4:
                    menuHopDong(qlHD, sc);
                    break;
                case 5:
                    menuChamCong(qlCC, sc);
                    break;
                case 6:
                    FileNhanVien.ghiFile(qlNV, "nhanvien.txt");
                    FileChucVu.ghiFile(qlCV, "chucvu.txt");
                    FilePhongBan.ghiFile(qlPB, "phongban.txt");
                    FileHopDong.ghiFile(qlHD, "hopdong.txt");
                    FileChamCong.ghiFile(qlCC, "chamcong.txt");
                    break;
                case 0:
                    System.out.println("Dang luu du lieu va thoat...");
                    FileNhanVien.ghiFile(qlNV, "nhanvien.txt");
                    FileChucVu.ghiFile(qlCV, "chucvu.txt");
                    FilePhongBan.ghiFile(qlPB, "phongban.txt");
                    FileHopDong.ghiFile(qlHD, "hopdong.txt");
                    FileChamCong.ghiFile(qlCC, "chamcong.txt");
                    System.out.println("Tam biet!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void menuNhanVien(DanhSachNhanVien qlNV, Scanner sc) {
        System.out.println("\n--- QUAN LY NHAN VIEN ---");
        System.out.println("1. Nhap n phan tu ban dau");
        System.out.println("2. Xuat danh sach");
        System.out.println("3. Them 1 nhan vien");
        System.out.println("4. Sua theo ma");
        System.out.println("5. Xoa theo ma");
        System.out.println("6. Tim kiem (theo ma hoac ten)");
        System.out.println("7. Thong ke nhan vien");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: qlNV.nhapNPhanTu(sc); break;
            case 2: qlNV.xuat(); break;
            case 3: qlNV.them(); break;
            case 4:
                System.out.print("Nhap ma NV can sua: ");
                qlNV.sua(sc.nextLine());
                break;
            case 5:
                System.out.print("Nhap ma NV can xoa: ");
                qlNV.xoa(sc.nextLine());
                break;
            case 6:
                System.out.print("Nhap tu khoa tim kiem: ");
                qlNV.timKiem(sc.nextLine());
                break;
            case 7: qlNV.thongKe(); break;
        }
    }

    private static void menuChucVu(DanhSachChucVu qlCV, Scanner sc) {
        System.out.println("\n--- QUAN LY CHUC VU ---");
        System.out.println("1. Xuat danh sach | 2. Them | 3. Sua | 4. Xoa | 5. Tim kiem");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: qlCV.xuat(); break;
            case 2: qlCV.them(); break;
            case 3: System.out.print("Nhap ma CV: "); qlCV.sua(sc.nextLine()); break;
            case 4: System.out.print("Nhap ma CV: "); qlCV.xoa(sc.nextLine()); break;
            case 5: System.out.print("Tu khoa: "); qlCV.timKiem(sc.nextLine()); break;
        }
    }

    private static void menuPhongBan(DanhSachPhongBan qlPB, Scanner sc) {
        System.out.println("\n--- QUAN LY PHONG BAN ---");
        System.out.println("1. Xuat danh sach | 2. Them | 3. Sua | 4. Xoa | 5. Tim kiem");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: qlPB.xuat(); break;
            case 2: qlPB.them(); break;
            case 3: System.out.print("Nhap ma PB: "); qlPB.sua(sc.nextLine()); break;
            case 4: System.out.print("Nhap ma PB: "); qlPB.xoa(sc.nextLine()); break;
            case 5: System.out.print("Tu khoa: "); qlPB.timKiem(sc.nextLine()); break;
        }
    }

    private static void menuHopDong(DanhSachHopDong qlHD, Scanner sc) {
        System.out.println("\n--- QUAN LY HOP DONG ---");
        System.out.println("1. Xuat danh sach | 2. Them | 3. Sua | 4. Xoa | 5. Tim kiem");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: qlHD.xuat(); break;
            case 2: qlHD.them(); break;
            case 3: System.out.print("Nhap ma HD: "); qlHD.sua(sc.nextLine()); break;
            case 4: System.out.print("Nhap ma HD: "); qlHD.xoa(sc.nextLine()); break;
            case 5: System.out.print("Tu khoa (Ma HD hoac Ma NV): "); qlHD.timKiem(sc.nextLine()); break;
        }
    }

    private static void menuChamCong(DanhSachChamCong qlCC, Scanner sc) {
        System.out.println("\n--- QUAN LY CHAM CONG ---");
        System.out.println("1. Xuat danh sach | 2. Them | 3. Sua | 4. Xoa | 5. Thong ke thang");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1: qlCC.xuat(); break;
            case 2: qlCC.them(); break;
            case 3: System.out.print("Nhap ma Cham Cong: "); qlCC.sua(sc.nextLine()); break;
            case 4: System.out.print("Nhap ma Cham Cong: "); qlCC.xoa(sc.nextLine()); break;
            case 5: 
                System.out.print("Nhap thang can thong ke: "); 
                qlCC.thongKeTheoThang(Integer.parseInt(sc.nextLine())); 
                break;
        }
    }
}