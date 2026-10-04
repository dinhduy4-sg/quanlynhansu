package quanlynhansu;

import java.io.*;

public class FileHopDong {
    public static void ghiFile(DanhSachHopDong ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsHD()[i].toFileString());
            }
            System.out.println("Ghi file hop dong thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachHopDong ds, String path) {
        File f = new File(path);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.split(",");
                ds.themVaoCuoi(new HopDong(p[0], p[1], p[2], p[3], p[4]));
            }
            System.out.println("Doc file hop dong thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}