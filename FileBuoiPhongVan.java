
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileBuoiPhongVan {

    public static void ghiFile(DanhSachBuoiPhongVan ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsPV()[i].toFileString());
            }

            System.out.println("Ghi file buoi phong van thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file buoi phong van: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachBuoiPhongVan ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 4) {
                    BuoiPhongVan pv = new BuoiPhongVan(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    ds.themVaoCuoi(pv);
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file buoi phong van: " + e.getMessage());
        }
    }
}
