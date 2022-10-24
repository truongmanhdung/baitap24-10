import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<PhongTro> phongs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Quản lý phòng trọ");
            System.out.println("1 . nhập vào phòng trọ cần quản lí");
            System.out.println("2 . tìm kiếm phòng trọ chưa có người thuê");
            System.out.println("3. tìm kiếm phòng trọ đang được sử dụng theo ngày kết thúc hợp đồng " +
                    "(ví dụ nhập vào ngày 01/10/2023 thì hiển thị thông tin tất cả các phòng có ngày kết thúc hợp đồng trước ngày 1-10-2023)");
            System.out.println("4. đăng kí thủ tục thuê phòng");
            System.out.println("5. xóa bỏ 1 phòng khỏi danh sách quản lí");
            System.out.println("6 . show toàn bộ thông tin danh sách phòng đang quản lí");
            System.out.println("7 . exit");
            System.out.println("Mời chọn số từ 1 -> 7 theo menu trên: ");
            int so = Integer.parseInt(sc.nextLine());
            if (!checkValidPhong() && so != 1) {
                System.out.println("Chưa có phòng trọ nên bạn chưa thể làm gì");
            } else {
                switch (so) {
                    case 1:
                        insertPhong();
                        menu();
                        break;
                    case 2:
                        searchPhong("checkValid");
                        menu();
                        break;
                    case 3:
                        searchPhong("checkDate");
                        menu();
                        break;
                    case 4:
                        dangKyPhong();
                        menu();
                        break;
                    case 5:
                        removePhong();
                        menu();
                        break;
                    case 6:
                        searchPhong("");
                        menu();
                        break;
                    case 7:
                        return;
                    default:
                        return;
                }
            }

        }
    }

    public static void insertPhong() {
        System.out.println("Mời bạn nhập số lượng phòng cần thêm: ");
        int so = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < so; i++) {
            System.out.println("Mời nhập vào phòng số: " + (i + 1));
            System.out.println("Mời bạn nhập tên phòng: " + (i + 1));
            String name = sc.nextLine();
            System.out.println("Mời bạn nhập giá phòng: " + (i + 1));
            int price = Integer.parseInt(sc.nextLine());
            PhongTro pt = new PhongTro(name, price);
            phongs.add(pt);
        }
    }

    public static void searchPhong(String keySearch) {
        switch (keySearch) {
            case "checkValid":
                System.out.println("Những phòng trọ chưa có người thuê là: ");
                for (PhongTro phong : phongs
                ) {
                    if (!phong.isCheckValid()) {
                        phong.inThongTinPhong();
                    }
                }
                break;
            case "checkDate":
                LocalDate date = nhapDate("cần search");
                for (PhongTro phong : phongs
                ) {
                    if (phong.getEndDate() != null && phong.getStartDate() != null && phong.getEndDate().isAfter(date) && phong.getStartDate().isBefore(date)) {
                        phong.inThongTinPhong();
                    }
                }
                break;
            default:
                System.out.println("Thông tin phòng: ");
                for (PhongTro phong : phongs
                ) {
                    phong.inThongTinPhong();
                }
                break;
        }
    }

    private static LocalDate nhapDate(String keyDate) {
        while (true) {
            try {
                System.out.println("Mời bạn nhập ngày " + keyDate);
                String a = sc.nextLine();
                return LocalDate.parse(a, dinhDang);
            } catch (Exception e) {
                System.out.println("Mời bạn nhập lại đúng định dạng " + "dd/MM/yyyy");
            }
        }
    }

    public static void dangKyPhong() {
        System.out.println("Mời bạn nhập vào mã phòng cần làm hợp đồng");
        String tenPhong = sc.nextLine();
        Boolean check = false;
        while (!check) {
            for (PhongTro phong : phongs
            ) {
                if (phong.getName().equals(tenPhong)) {
                    if (phong.isCheckValid()) {
                        System.out.println("Phòng đã được thuê, vui lòng chọn phòng khác");
                        check = false;
                    } else {
                        System.out.println("Mời bạn nhập người thuê phòng: ");
                        phong.setNguoiThue(sc.nextLine());
                        phong.setStartDate(nhapDate("ngày bắt đầu"));
                        System.out.println("Mời bạn nhập thời gian muốn thuê, tính theo năm: ");
                        long namThue = Long.parseLong(sc.nextLine());
                        phong.setEndDate(phong.getStartDate().plusYears(namThue));
                        phong.setCheckValid(true);
                        check = true;
                    }
                }
            }
        }

    }

    public static boolean checkValidPhong() {
        return phongs.size() > 0;
    }

    public static void removePhong() {
        System.out.println("Mời bạn nhập vào mã phòng cần xoá");
        String tenPhong = sc.nextLine();
        phongs.removeIf(phong -> phong.getName().equals(tenPhong));
    }

}