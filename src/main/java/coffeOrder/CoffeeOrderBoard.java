package coffeOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoffeeOrderBoard {
    private List<Order> orders;
    private int nextOrderNumber;

    private Logger logger;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;

        logger = Logger.getLogger("CoffeeOrderBoard");
        logger.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("coffee_order.log");
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) {
        order.setOrderNumber(nextOrderNumber);
        orders.add(order);
        logger.info("Order " + order.getOrderNumber() + " added for " + order.getCustomerName());
        nextOrderNumber++;
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.get(0);
            System.out.println("Delivering order: " + nextOrder.getOrderNumber() + " | " + nextOrder.getCustomerName());
            orders.remove(0);
            logger.info("Delivered order " + nextOrder.getOrderNumber() + " for " + nextOrder.getCustomerName());
        } else {
            System.out.println("No orders to deliver.");
            logger.severe("Order with number " + nextOrderNumber + " not found");
        }
    }

    public void deliverN(int orderNumber) {
        int index = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Order order = orders.get(index);
            System.out.println("Delivering order: " + order.getOrderNumber() + " | " + order.getCustomerName());
            logger.info("Delivered order " + order.getOrderNumber() + " for " + order.getCustomerName());
            orders.remove(index);
        } else {
            logger.severe("Order with number " + orderNumber + " not found");
            System.out.println("Order with number " + orderNumber + " not found.");
        }
    }

    public void draw() {
        System.out.println("======================");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
        System.out.println("======================");
    }
}
