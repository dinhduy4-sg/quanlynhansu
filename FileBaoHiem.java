
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileBaoHiem {

    public static void ghiFile(DanhSachBaoHiem ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsBH()[i].toFileString());
            }

            System.out.println("Ghi file bao hiem thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi ghi file bao hiem: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachBaoHiem ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    BaoHiem bh = new BaoHiem(
                            data[0],
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]
                    );

                    ds.themVaoCuoi(bh);
                }
            }
        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file bao hiem: " + e.getMessage());
        }
    }
}
