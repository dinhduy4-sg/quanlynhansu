package quanlynhansu;

public class ChiTietHopDong {
    private String maHD;
    private String diaDiemLamViec;
    private String cheDoBaoHiem;
    private double luongCoBan; // Bổ sung thêm thông tin chi tiết thường có
    
    // Tham chiếu ngược lại đến HopDong (giúp liên kết 2 chiều nếu cần)
    private HopDong hopDong;

    // 1. Constructor mặc định không tham số
    public ChiTietHopDong() {}

    // 2. Constructor đầy đủ tham số cơ bản
    public ChiTietHopDong(String maHD, String diaDiemLamViec, String cheDoBaoHiem, double luongCoBan) {
        this.maHD = maHD;
        this.diaDiemLamViec = diaDiemLamViec;
        this.cheDoBaoHiem = cheDoBaoHiem;
        this.luongCoBan = luongCoBan;
    }

    // --- CÁC PHƯƠNG THỨC GETTER VÀ SETTER ---
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getDiaDiemLamViec() {
        return diaDiemLamViec;
    }

    public void setDiaDiemLamViec(String diaDiemLamViec) {
        this.diaDiemLamViec = diaDiemLamViec;
    }

    public String getCheDoBaoHiem() {
        return cheDoBaoHiem;
    }

    public void setCheDoBaoHiem(String cheDoBaoHiem) {
        this.cheDoBaoHiem = cheDoBaoHiem;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
    // ----------------------------------------

    // Phương thức xuất thông tin chi tiết
    public void xuat() {
        System.out.println("Địa điểm: " + diaDiemLamViec 
                         + " | Bảo hiểm: " + cheDoBaoHiem 
                         + " | Lương cơ bản: " + String.format("%,.0f VNĐ", luongCoBan));
    }
}
