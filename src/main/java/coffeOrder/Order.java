package coffeOrder;

public class Order {
    private int orderNumber;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
