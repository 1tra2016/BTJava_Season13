import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        int autoId = 1;

        while (true) {
            System.out.println("************* MENU QUẢN LÝ HÓA ĐƠN *************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    String id;
                    while (true) {
                        System.out.print("Nhập mã đơn hàng: ");
                        id = sc.nextLine();
                        if (!id.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống");
                    }
                    String name;
                    while (true) {
                        System.out.print("Nhập tên khách hàng: ");
                        name = sc.nextLine();
                        if (!name.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống");
                    }

                    manager.add(new Order(id, name));
                    break;
                }

                case "2": {
                    manager.display();
                    System.out.print("Nhập id đơn hàng cần sửa: ");
                    String id = sc.nextLine();

                    int index = manager.findIndexById(id);
                    if (index==-1) {
                        System.out.println("Không tìm thấy đơn hàng.");
                        break;
                    }

                    String newName;
                    while (true) {
                        System.out.print("Nhập tên khách hàng mới: ");
                        newName = sc.nextLine();
                        if (!newName.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống");
                    }

                    manager.update(index, new Order(id, newName));
                    break;
                }

                case "3": {
                    manager.display();
                    System.out.print("Nhập id đơn hàng cần xóa: ");
                    String id = sc.nextLine();

                    int index = manager.findIndexById(id);
                    manager.delete(index);
                    break;
                }

                case "4":
                    manager.display();
                    break;

                case "5":
                    System.out.println("Thoát chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không tồn tại");
            }
        }
    }
}
