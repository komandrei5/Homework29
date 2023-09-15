package coffeOrder;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.addOrder(new Order("Alen"));
        coffeeOrderBoard.addOrder(new Order("Tomas"));
        coffeeOrderBoard.addOrder(new Order("Make"));
        coffeeOrderBoard.addOrder(new Order("Ross"));
        coffeeOrderBoard.addOrder(new Order("Mary"));

        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliverN(4);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.addOrder(new Order("Tonny"));
        coffeeOrderBoard.draw();
    }
}
