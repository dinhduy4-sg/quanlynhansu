
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileChiTietLuong {

    // Ghi danh sach chi tiet luong vao file
    public static void ghiFile(DanhSachChiTietLuong ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            ChiTietLuong[] mang = ds.getDsCTL();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file chi tiet luong thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file chi tiet luong: "
                    + e.getMessage());
        }
    }

    // Doc danh sach chi tiet luong tu file
    public static void docFile(DanhSachChiTietLuong ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 5) {
                    ChiTietLuong ctl = new ChiTietLuong(
                            Double.parseDouble(data[0]),
                            Double.parseDouble(data[1]),
                            Double.parseDouble(data[2]),
                            Double.parseDouble(data[3]),
                            Double.parseDouble(data[4])
                    );

                    ds.themVaoCuoi(ctl);
                }
            }

            System.out.println("Doc file chi tiet luong thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file chi tiet luong: "
                    + e.getMessage());
        }
    }
}
