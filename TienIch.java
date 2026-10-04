package quanlynhansu;

public class TienIch {
    public static boolean kiemTraRong(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean kiemTraSoDuong(double giaTri) {
        return giaTri >= 0;
    }
}