import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void add(Order item) {
        orders.add(item);
        System.out.println("Đơn hàng đã được thêm thành công");
    }

    @Override
    public void update(int index, Order item) {
        if (index < 0 || index >= orders.size()) {
            System.out.println("Không tìm thấy đơn hàng");
            return;
        }
        orders.set(index, item);
        System.out.println("Hóa đơn đã được sửa thành công");
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= orders.size()) {
            System.out.println("Không tìm thấy đơn hàng");
            return;
        }
        orders.remove(index);
        System.out.println("Hóa đơn đã được xóa thành công");
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống");
            return;
        }
        for (Order i : orders) {
            System.out.println(i);
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
