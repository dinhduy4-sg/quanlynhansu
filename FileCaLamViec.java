
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCaLamViec {

    // Ghi danh sach ca lam viec vao file
    public static void ghiFile(DanhSachCaLamViec ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            CaLamViec[] mang = ds.getDsCa();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file ca lam viec thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file ca lam viec: "
                    + e.getMessage());
        }
    }

    // Doc danh sach ca lam viec tu file
    public static void docFile(DanhSachCaLamViec ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    CaLamViec ca = new CaLamViec(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(ca);
                }
            }

            System.out.println("Doc file ca lam viec thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file ca lam viec: "
                    + e.getMessage());
        }
    }
}
