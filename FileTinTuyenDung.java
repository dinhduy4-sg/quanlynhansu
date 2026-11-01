
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileTinTuyenDung {

    public static void ghiFile(DanhSachTinTuyenDung ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsTTD()[i].toFileString());
            }

            System.out.println("Ghi file tin tuyen dung thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file tin tuyen dung: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachTinTuyenDung ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 5) {
                    TinTuyenDung tin = new TinTuyenDung(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            Double.parseDouble(data[4])
                    );

                    ds.themVaoCuoi(tin);
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file tin tuyen dung: " + e.getMessage());
        }
    }
}
