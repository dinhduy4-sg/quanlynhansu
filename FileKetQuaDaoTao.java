
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileKetQuaDaoTao {

    // Ghi danh sách kết quả đào tạo xuống file
    public static void ghiFile(
            DanhSachKetQuaDaoTao ds,
            String tenFile) {

        try {
            PrintWriter pw = new PrintWriter(
                    new FileWriter(tenFile));

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsKQDT()[i].toFileString());
            }

            pw.close();

            System.out.println("Ghi file ket qua dao tao thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Đọc danh sách kết quả đào tạo từ file
    public static void docFile(
            DanhSachKetQuaDaoTao ds,
            String tenFile) {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(tenFile));

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                KetQuaDaoTao kqdt = new KetQuaDaoTao(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                );

                ds.themVaoCuoi(kqdt);
            }

            br.close();

            System.out.println("Doc file ket qua dao tao thanh cong!");

        } catch (FileNotFoundException e) {
            System.out.println("File ket qua dao tao chua ton tai!");

        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}
