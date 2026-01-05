import java.util.Scanner;

public class Person {
    Scanner sc = new Scanner(System.in);
    private String name;
    private String email;
    private String phone;

    public Person() {
    }

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}

    public void inputData() {
        while (true) {
            System.out.print("Nhập tên người dùng: ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) break;
            System.out.println("Vui lòng ko để trống");
        }

        while (true) {
            System.out.print("Nhập email người dùng: ");
            email = sc.nextLine();
            if (!email.trim().isEmpty()) break;
            System.out.println("Vui lòng ko để trống");
        }

        while (true) {
            System.out.print("Nhập số điện thoại người dùng: ");
            phone = sc.nextLine();
            if (!phone.trim().isEmpty()) break;
            System.out.println("Vui lòng ko để trống");
        }
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Email: " + email + ", Số điện thoại: " + phone;
    }
}
