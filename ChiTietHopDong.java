package quanlynhansu;

public class ChiTietHopDong {
    private String maHD;
    private String diaDiemLamViec;
    private String cheDoBaoHiem;
    private double luongCoBan;
    private HopDong hopDong;
    public ChiTietHopDong() {}
    public ChiTietHopDong(String maHD, String diaDiemLamViec, String cheDoBaoHiem, double luongCoBan) {
        this.maHD = maHD;
        this.diaDiemLamViec = diaDiemLamViec;
        this.cheDoBaoHiem = cheDoBaoHiem;
        this.luongCoBan = luongCoBan;
    }

    
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
  
    public void xuat() {
        System.out.println("Dia diem: " + diaDiemLamViec 
                         + " | Bao hiem: " + cheDoBaoHiem 
                         + " | Luong co ban: " + String.format("%,.0f VNĐ", luongCoBan));
    }
}
