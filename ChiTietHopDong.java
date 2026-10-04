package quanlynhansu;

public class ChiTietHopDong {
    private String maHD;
    private String diaDiemLamViec;
    private String cheDoBaoHiem;

    public ChiTietHopDong() {}

    public ChiTietHopDong(String maHD, String diaDiemLamViec, String cheDoBaoHiem) {
        this.maHD = maHD;
        this.diaDiemLamViec = diaDiemLamViec;
        this.cheDoBaoHiem = cheDoBaoHiem;
    }

    public void xuat() {
        System.out.println("Ma HD: " + maHD + " | Noi lam viec: " + diaDiemLamViec + " | Bao hiem: " + cheDoBaoHiem);
    }
}