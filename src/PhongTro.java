import java.time.LocalDate;
import java.util.Date;

public class PhongTro {
    private String name;

    private int price;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean checkValid = false;

    private String nguoiThue;


    public PhongTro(String name, int price) {
        this.name = name;
        this.price = price;
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


    public String getNguoiThue() {
        return nguoiThue;
    }

    public void setNguoiThue(String nguoiThue) {
        this.nguoiThue = nguoiThue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isCheckValid() {
        return checkValid;
    }

    public void setCheckValid(boolean checkValid) {
        this.checkValid = checkValid;
    }

    public void inThongTinPhong(){
        String checkVali = this.getEndDate() != null && this.getStartDate() != null && this.getEndDate().isAfter(LocalDate.now()) && this.getStartDate().isBefore(LocalDate.now()) ? "và đang sử dụng" : "nhưng chưa sử dụng";
        String tinhTrang = this.isCheckValid() ? "Đã được đặt phòng" + checkVali : "Đang trống";
        System.out.println("Thông tin phòng trọ: ");
        System.out.println("- Tên phòng: " + this.name + "- giá phòng:  "
                + this.price + "- Ngày được thuê: " + this.startDate + "- Ngày kết thúc hợp đồng: " + this.endDate + "- Tình trạng phòng: " + tinhTrang);
        if(this.nguoiThue != null){
            System.out.println("Người thuê: " + this.nguoiThue);
        }
    }
}
