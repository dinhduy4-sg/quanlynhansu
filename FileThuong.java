
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileThuong {

    public static void ghiFile(DanhSachThuong ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsThuong()[i].toFileString());
            }

            System.out.println("Ghi file thuong thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file thuong: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachThuong ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    Thuong t = new Thuong(
                            data[0],
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]
                    );

                    ds.themVaoCuoi(t);
                }
            }
        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file thuong: " + e.getMessage());
        }
    }
}
