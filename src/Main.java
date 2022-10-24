import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<PhongTro> phongs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
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
            switch (so){
                case 1:
                    insertPhong();
                case 2:
                    searchPhong();
                case 3:
                    searchPhongValid();
                case 4:
                    dangKyPhong();
                case 5:
                    removePhong();
                case 6:
                    thongKePhong();
                case 7:
                    return;

                default:
                    return;
            }
        }
    }

    public static void insertPhong(){
        System.out.println("Mời bạn nhập số lượng phòng cần thêm: ");
        int so = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < so; i++){
            System.out.println("Mời nhập vào phòng số: " + (i + 1));
            System.out.println("Mời bạn nhập tên phòng: " + (i + 1));
            String name = sc.nextLine();
            System.out.println("Mời bạn nhập giá phòng: "+ (i + 1));
            int price = Integer.parseInt(sc.nextLine());

        }
    }

    public static void searchPhong(){

    }

    public static void searchPhongValid(){

    }

    public static void dangKyPhong(){

    }

    public static void removePhong(){

    }
    public static void thongKePhong(){

    }

}