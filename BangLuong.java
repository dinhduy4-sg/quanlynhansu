package quanlynhansu;

public class BangLuong {
    private String maBangLuong;
    private String maNV;
    private int thang;
    private double thucLinh;

    public BangLuong(String maBangLuong, String maNV, int thang, double thucLinh) {
        this.maBangLuong = maBangLuong;
        this.maNV = maNV;
        this.thang = thang;
        this.thucLinh = thucLinh;
    }

    public void xuat() {
        System.out.printf("Ma BL: %-8s | Ma NV: %-8s | Thang: %-2d | Thuc Linh: %-12.1f\n", 
                maBangLuong, maNV, thang, thucLinh);
    }
}
