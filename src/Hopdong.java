import java.time.LocalDate;
import java.util.Date;

public class Hopdong {
    private String nameKH;
    private PhongTro phong;

    public Hopdong(String nameKH, PhongTro phong) {
        this.nameKH = nameKH;
        this.phong = phong;
    }

    public void inHopDong() {
        System.out.println("In thông tin hợp đồng: ");
        System.out.println("Tên khách hàng: " + this.nameKH);
        this.phong.inThongTinPhong();
    }
}
