package quanlynhansu;

import java.io.*;

public class FileChucVu {
    public static void ghiFile(DanhSachChucVu ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsCV()[i].toFileString());
            }
            System.out.println("Ghi file chuc vu thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachChucVu ds, String path) {
        File f = new File(path);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.split(",");
                ds.themVaoCuoi(new ChucVu(p[0], p[1], Double.parseDouble(p[2])));
            }
            System.out.println("Doc file chuc vu thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file chuc vu: " + e.getMessage());
        }
    }
}