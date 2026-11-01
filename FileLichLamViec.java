
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLichLamViec {

    // Ghi danh sach lich lam viec vao file
    public static void ghiFile(DanhSachLichLamViec ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            LichLamViec[] mang = ds.getDsLich();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file lich lam viec thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file lich lam viec: "
                    + e.getMessage());
        }
    }

    // Doc danh sach lich lam viec tu file
    public static void docFile(DanhSachLichLamViec ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    LichLamViec lich = new LichLamViec(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(lich);
                }
            }

            System.out.println("Doc file lich lam viec thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file lich lam viec: "
                    + e.getMessage());
        }
    }
}
