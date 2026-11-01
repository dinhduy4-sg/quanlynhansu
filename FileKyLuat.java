
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileKyLuat {

    // Ghi danh sach ky luat vao file
    public static void ghiFile(DanhSachKyLuat ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            KyLuat[] mang = ds.getDsKL();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file ky luat thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file ky luat: " + e.getMessage());
        }
    }

    // Doc danh sach ky luat tu file
    public static void docFile(DanhSachKyLuat ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    KyLuat kl = new KyLuat(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(kl);
                }
            }

            System.out.println("Doc file ky luat thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file ky luat: " + e.getMessage());
        }
    }
}
