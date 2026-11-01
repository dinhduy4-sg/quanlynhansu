
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHopDongLaoDong {

    // Ghi danh sach hop dong lao dong vao file
    public static void ghiFile(DanhSachHopDongLaoDong ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            HopDongLaoDong[] mang = ds.getDsHDLD();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file hop dong lao dong thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file hop dong lao dong: "
                    + e.getMessage());
        }
    }

    // Doc danh sach hop dong lao dong tu file
    public static void docFile(DanhSachHopDongLaoDong ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    HopDongLaoDong hd = new HopDongLaoDong(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(hd);
                }
            }

            System.out.println("Doc file hop dong lao dong thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file hop dong lao dong: "
                    + e.getMessage());
        }
    }
}
