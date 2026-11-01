
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePhanCongCongViec {

    // Ghi danh sach phan cong cong viec vao file
    public static void ghiFile(DanhSachPhanCongCongViec ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            PhanCongCongViec[] mang = ds.getDsPC();

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(mang[i].toFileString());
            }

            System.out.println("Ghi file phan cong cong viec thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file phan cong cong viec: "
                    + e.getMessage());
        }
    }

    // Doc danh sach phan cong cong viec tu file
    public static void docFile(DanhSachPhanCongCongViec ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    PhanCongCongViec pc = new PhanCongCongViec(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(pc);
                }
            }

            System.out.println("Doc file phan cong cong viec thanh cong!");
        } catch (java.io.FileNotFoundException e) {
            // File chua ton tai thi bo qua
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file phan cong cong viec: "
                    + e.getMessage());
        }
    }
}
