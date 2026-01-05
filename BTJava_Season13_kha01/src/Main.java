import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager manager = new UserManager();

        while (true) {
            System.out.println("************* MENU QUẢN LÝ NGƯỜI DÙNG *************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    manager.addUser();
                    break;
                case "2":
                    manager.deleteUserByEmail();
                    break;
                case "3":
                    manager.displayUsers();
                    break;
                case "4":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không tồn tại");
            }
        }
    }
}
