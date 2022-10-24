import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class PhongTro {
    private String name;

    private UUID maPhong = UUID.randomUUID();;
    private int price;

    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate;
    private boolean checkValid = false;

    public PhongTro(String name, int price, Date endDate) {
        this.name = name;
        this.price = price;
    }

    public PhongTro(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public PhongTro(String name, int price, LocalDate endDate, boolean checkValid) {
        this.name = name;
        this.price = price;
        this.endDate = endDate;
        this.checkValid = checkValid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCheckValid() {
        return checkValid;
    }

    public void setCheckValid(boolean checkValid) {
        this.checkValid = checkValid;
    }

    public void inThongTinPhong(){
        String tinhTrang = this.isCheckValid() ? "Đang sử dụng" : "Đang trống";
        System.out.println("Thông tin phòng trọ: ");
        System.out.println("Mã phòng: "+ this.maPhong + "- Tên phòng: " + this.name + "- giá phòng:  "
                + this.price + "- Ngày được thuê: " + this.startDate + "- Ngày kết thúc hợp đồng: " + this.endDate + "- Tình trạng phòng: " + tinhTrang);
    }
}
