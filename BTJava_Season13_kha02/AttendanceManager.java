import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void add(Student item) {
        students.add(item);
        System.out.println("Thêm thành công");
    }

    @Override
    public void update(int index, Student item) {
        if (index < 0 || index >= students.size()) {
            System.out.println("Không tìm thấy sinh viên");
            return;
        }
        students.set(index, item);
        System.out.println("Update thành công");
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= students.size()) {
            System.out.println("Không tìm thấy");
            return;
        }
        students.remove(index);
        System.out.println("Sinh viên đã được xóa thành công");
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
