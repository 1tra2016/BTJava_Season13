import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> invoices = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoices.add(item);
        System.out.println("Hóa đơn đã được thêm thành công");
    }

    @Override
    public void update(int index, Invoice item) {
        if (index < 0 || index >= invoices.size()) {
            System.out.println("Không tìm thấy hóa đơn");
            return;
        }
        invoices.set(index, item);
        System.out.println("Hóa đơn đã được sửa thành công");
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= invoices.size()) {
            System.out.println("Không tìm thấy hóa đơn");
            return;
        }
        invoices.remove(index);
        System.out.println("Hóa đơn đã được xóa thành công");
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống");
            return;
        }
        for (Invoice i : invoices) {
            System.out.println(i);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
