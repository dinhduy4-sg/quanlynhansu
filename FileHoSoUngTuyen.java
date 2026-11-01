
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileHoSoUngTuyen {

    public static void ghiFile(DanhSachHoSoUngTuyen ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsHS()[i].toFileString());
            }

            System.out.println("Ghi file ho so ung tuyen thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file ho so ung tuyen: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachHoSoUngTuyen ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 5) {
                    HoSoUngTuyen hs = new HoSoUngTuyen(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    ds.themVaoCuoi(hs);
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file ho so ung tuyen: " + e.getMessage());
        }
    }
}
