import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();
        int autoId = 1;

        while (true) {
            System.out.println("************* MENU QUẢN LÝ HÓA ĐƠN *************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    String code;
                    while (true) {
                        System.out.print("Nhập mã hóa đơn: ");
                        code = sc.nextLine();
                        if (!code.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống");
                    }

                    double amount;
                    while (true) {
                        try {
                            System.out.print("Nhập số tiền: ");
                            amount = Double.parseDouble(sc.nextLine());
                            if (amount >= 0) break;
                            System.out.println("Vui lòng nhập số thực >= 0");
                        } catch (Exception e) {
                            System.out.println("Vui lòng nhập số thực >= 0");
                        }
                    }

                    manager.add(new Invoice(autoId++, code, amount));
                    break;
                }

                case "2": {
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần sửa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    int index = manager.findIndexById(id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy hóa đơn.");
                        break;
                    }

                    String newCode;
                    while (true) {
                        System.out.print("Nhập mã hóa đơn mới: ");
                        newCode = sc.nextLine();
                        if (!newCode.trim().isEmpty()) break;
                        System.out.println("Vui lòng ko để trống");
                    }

                    double newAmount;
                    while (true) {
                        try {
                            System.out.print("Nhập số tiền mới: ");
                            newAmount = Double.parseDouble(sc.nextLine());
                            if (newAmount >= 0) break;
                            System.out.println("Vui lòng nhập số thực >= 0");
                        } catch (Exception e) {
                            System.out.println("Vui lòng nhập số thực >= 0");
                        }
                    }

                    manager.update(index, new Invoice(id, newCode, newAmount));
                    break;
                }

                case "3": {
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần xóa: ");
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
