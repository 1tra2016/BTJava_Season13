import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        while (true) {
            System.out.println("************* MENU QUẢN LÝ ĐIỂM DANH *************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    System.out.print("Nhập id sinh viên: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên sinh viên: ");
                    String name = sc.nextLine();

                    manager.add(new Student(id, name));
                    break;
                }

                case "2": {
                    manager.display();
                    System.out.print("Nhập id sinh viên cần sửa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    int index = manager.findIndexById(id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sinh viên.");
                        break;
                    }

                    System.out.print("Nhập tên mới sinh viên: ");
                    String newName = sc.nextLine();

                    Student updatedStudent = new Student(id, newName);
                    manager.update(index, updatedStudent);
                    break;
                }

                case "3": {
                    manager.display();
                    System.out.print("Nhập id sinh viên cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    int index = manager.findIndexById(id);
                    manager.delete(index);
                    break;
                }

                case "4":
                    manager.display();
                    break;

                case "5":
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
