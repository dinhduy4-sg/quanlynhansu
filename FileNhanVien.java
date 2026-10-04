package quanlynhansu;

import java.io.*;

public class FileNhanVien {
    public static void ghiFile(DanhSachNhanVien ds, String duongDan) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(duongDan))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsNV()[i].toFileString());
            }
            System.out.println("Ghi file nhan vien thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachNhanVien ds, String duongDan) {
        File f = new File(duongDan);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.split(",");
                if (p[0].equals("CT")) {
                    NhanVienChinhThuc nv = new NhanVienChinhThuc(p[1], p[2], p[3], p[4], p[5],
                            Double.parseDouble(p[6]), Double.parseDouble(p[7]), Double.parseDouble(p[8]));
                    ds.themVaoCuoi(nv);
                } else if (p[0].equals("TV")) {
                    NhanVienThoiVu nv = new NhanVienThoiVu(p[1], p[2], p[3], p[4], p[5],
                            Double.parseDouble(p[6]), Double.parseDouble(p[7]), Double.parseDouble(p[8]));
                    ds.themVaoCuoi(nv);
                }
            }
            System.out.println("Doc file nhan vien thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file nhan vien: " + e.getMessage());
        }
    }
}