
package quanlynhansu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileNghiPhep {

    public static void ghiFile(DanhSachNghiPhep ds, String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {

            for (int i = 0; i < ds.getSoLuong(); i++) {
                pw.println(ds.getDsNP()[i].toFileString());
            }

            System.out.println("Ghi file nghi phep thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file nghi phep: " + e.getMessage());
        }
    }

    public static void docFile(DanhSachNghiPhep ds, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length >= 5) {
                    NghiPhep np = new NghiPhep(
                                data[0],
                                data[1],
                                Integer.parseInt(data[2]),
                                data[3],
                                data[4]
                        );
                    ds.themVaoCuoi(np);
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (Exception e) {
            System.out.println("Loi doc file nghi phep: " + e.getMessage());
        }
    }
}
