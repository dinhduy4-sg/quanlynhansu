
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileKhoaDaoTao {

    public static void ghiFile(DanhSachKhoaDaoTao ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsKDT()[i].toFileString());
            }

            System.out.println("Ghi file khoa dao tao thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file khoa dao tao: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachKhoaDaoTao ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    KhoaDaoTao khoa = new KhoaDaoTao(
                            data[0],
                            data[1],
                            data[2],
                            Double.parseDouble(data[3])
                    );

                    ds.themVaoCuoi(khoa);
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file khoa dao tao: " + e.getMessage());
        }
    }
}
