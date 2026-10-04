package quanlynhansu;

import java.io.*;

public class FileChamCong {
    public static void ghiFile(DanhSachChamCong ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsCC()[i].toFileString());
            }
            System.out.println("Ghi file cham cong thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachChamCong ds, String path) {
        File f = new File(path);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.split(",");
                ds.themVaoCuoi(new ChamCong(p[0], p[1], Integer.parseInt(p[2]), 
                        Integer.parseInt(p[3]), Integer.parseInt(p[4])));
            }
            System.out.println("Doc file cham cong thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}