import jdk.nashorn.internal.runtime.regexp.joni.Config;

import java.util.Scanner;

public class Main {
    static Book[] listbook = new Book[100];
    static int size = 0;

    public static void main(String[] args) {

        int choice;
        while (true) {
            System.out.println("=================MENU=================");
            System.out.println("1. Hiển thị toàn bộ sach");
            System.out.println("2. Thêm mới sach");
            System.out.println("3. Cập nhập thông tin sach");
            System.out.println("4. Xóa sach");
            System.out.println("5. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("6. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("7. Thoát");
            System.out.println("Hãy nhập vào lựa chọn của bạn");
            choice = config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // hiển thị danh sách
                    hienthi();
                    break;
                case 2:

                    themMoiSach();
                    break;
                case 3:
                    sua();
                    // cập nhật thông tin sản phẩm
                    break;
                case 4:
                    // xóa sản phẩm
                    xoa();
                    break;
                case 5:
                    sapxep();
                    break;
                case 6:
                 timKiemSach();
                    break;
                case 7:
                    //
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.err.println("hãy nhập 1 số từ 1 đến 7");
            }
        }
    }

    public static void hienthi() {
        if (size == 0) {
            System.err.println("Danh sách sản phẩm trống");
            return;
        }

        System.out.println("Danh sách Sản phẩm");
        for (Book book : listbook) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    public static void themMoiSach() {
        if (size == listbook.length) {
            System.err.println("Danh sách sách đã đầy. Không thể thêm mới sách.");
            return;
        }
        System.out.println("nhập số lượng sách cần thêm mới");
        int n = config.scanner().nextInt();
        for (int i = 0; i < n; i++) {

            Book newsach = new Book();
            System.out.println("Nhập thông tin sách mới:");
            System.out.print("Tên sách: ");

            newsach.setTensach(config.scanner().nextLine());
            System.out.print("Tên tác giả: ");
            newsach.setTacgia(config.scanner().nextLine());
            System.out.print("Mô tả: ");
            newsach.setMota(config.scanner().nextLine());
            System.out.print("giá nhập ");
            double gianhap = config.scanner().nextDouble();
            newsach.setGianhap(gianhap);
            System.out.print("giá xuất ");
            double giaxuat = config.scanner().nextDouble();
            newsach.setGiaxuat(giaxuat);
            float loinhuan = (float) (giaxuat - gianhap);
            newsach.setLoinhan(loinhuan);
            newsach.setTrangthai(true);

            int idMax = 0;  // tạo id lớn nhất
            for (Book p : listbook) {   // duyệt mảng sản phẩm để tìm ra id lớn nhất
                if (p == null) {        // nếu sản phẩm null, chương trình sẽ ném lỗi nullpoiterexeption, khối if này sẽ giải quyết điều đó
                    continue;   // nếu sản phẩm  == null sẽ bỏ qua vòng lặp
                }
                if (idMax < p.getIdsach()) {  // gán max id
                    idMax = p.getIdsach();
                }
            }
            newsach.setIdsach(idMax + 1);

            for (int j = 0; j < listbook.length; j++) {
                if (listbook[j] == null) {
                    listbook[j] = newsach;
                    size++;
                    System.out.println("Thêm mới sách thành công.");
                   break;
                }
            }
        }
    }

    public static void xoa() {
        if (size == 0) {
            System.err.println("Danh sách sách trống. Không thể xóa.");
            return;
        }


        System.out.println("Nhập id  sách cần xóa:");
        int id = config.scanner().nextInt();


        for (int i = 0; i < listbook.length; i++) {  //xóa sản phẩm
            if (listbook[i] == null) continue;
            if (listbook[i].getIdsach() == id) {
                System.out.println(listbook[i].toString());
                listbook[i] = null;
                size--;

                System.out.println("da xoa san pham nay thanh cong");
                return;
            }
        }
    }

    public static void sua() {

        System.out.println("Nhập tên id sách cần cập nhật:");
        int id = config.scanner().nextInt();

        if (size == 0) {
            System.err.println("Danh sách sách trống. Không thể xóa.");
            return;
        }
        for (int i = 0; i < listbook.length; i++) {
            if (listbook[i] == null) {
                continue;
            }

            if (listbook[i].getIdsach() == (id)) {
                System.out.println("Thông tin sách cần cập nhật:");
                System.out.println(listbook[i]);
                Book editsach = new Book();
                System.out.print("Tên sách: ");
                editsach.setTensach(config.scanner().nextLine());
                System.out.print("Tên tac gia: ");
                editsach.setTacgia(config.scanner().nextLine());
                System.out.print("Mô tả: ");
                editsach.setMota(config.scanner().nextLine());
                System.out.print("gia nhap ");
                double gianhap = config.scanner().nextDouble();
                editsach.setGianhap(gianhap);
                System.out.print("gia xuat ");
                double giaxuat = config.scanner().nextDouble();
                editsach.setGiaxuat(giaxuat);
                float loinhuan = (float) (giaxuat - gianhap);
                editsach.setLoinhan(loinhuan);
                System.out.println("chinh sua trang thai");
                System.out.println("1.true");
                System.out.println("2.fasle");
                int trangthai = config.scanner().nextInt();
                if (trangthai == 1) {
                    editsach.setTrangthai(true);
                } else {
                    editsach.setTrangthai(false);
                }
                listbook[i] = editsach;

                System.out.println("Cập nhật thông tin sách thành công.");

                return;
            }
        }


        System.err.println("Không tìm thấy sách cần cập nhật.");

    }
    public static void sapxep() {
        if (size == 0) {
            System.err.println("Danh sách sách trống.");
            return;
        }

        for (int i = 0; i < listbook.length - 1; i++) {
            for (int j = i + 1; j < listbook.length; j++) {
                if (listbook[i] != null && listbook[j] != null && listbook[i].getLoinhan() > listbook[j].getLoinhan()) {
                    Book hoandoi = listbook[i];
                    listbook[i] = listbook[j];
                    listbook[j] = hoandoi;
                }
            }
        }


        System.out.println("Sắp xếp sách theo lợi nhuận tăng dần thành công.");
    }
    public static void timKiemSach() {
        if (size == 0) {
            System.err.println("Danh sách sách trống.");
            return;
        }



        System.out.println("Nhập từ khóa tìm kiếm:");
        String tukhoa = config.scanner().nextLine();

  int check=-1;

        for (int i = 0; i <listbook.length ; i++) {
              if(listbook[i] == null ){
                continue;
            }
            if (listbook[i].getTensach().toLowerCase().contains(tukhoa.toLowerCase())
                    || listbook[i].getMota().toLowerCase().contains(tukhoa.toLowerCase())) {
                System.out.println(listbook[i]);
                check = i;
            }
        }

        if (check==-1) {
            System.out.println("Không tìm thấy sách .");
        }
    }

}
