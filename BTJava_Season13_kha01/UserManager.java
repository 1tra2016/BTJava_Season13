import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UserManager {
    private LinkedList<Person> users = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public void addUser() {
        Person p = new Person();
        p.inputData();
        users.add(p);
        System.out.println("Người dùng đã thêm thành công");
    }

    public void deleteUserByEmail() {
        System.out.print("Nhập email người dùng để xóa: ");
        String email = sc.nextLine();

        Iterator<Person> iterator = users.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getEmail().equalsIgnoreCase(email)) {
                iterator.remove();
                System.out.println("Người dùng đã được xóa thành công");
                return;
            }
        }
        System.out.println("Email k tồn tại");
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("Danh sách người dùng trống");
            return;
        }

        System.out.println("Danh sách người dùng:");
        for (Person p : users) {
            System.out.println(p);
        }
    }
}
