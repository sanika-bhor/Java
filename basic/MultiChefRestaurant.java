class DishMaker extends Thread {
    private String dish;

    public DishMaker(String dish) {
        this.dish = dish;
    }

    @Override
    public void run() {
        System.out.println(dish + " preparation started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate cooking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dish + " is ready!");
    }
}

public class MultiChefRestaurant {
    public static void main(String[] args) {
        Thread chef1 = new DishMaker("Pasta");
        Thread chef2 = new DishMaker("Coffee");
        Thread chef3 = new DishMaker("Dessert");

        chef1.start();
        chef2.start();
        chef3.start();
    }
}