package hybridSolution.inventory;

import hybridSolution.CoffeeType;

import java.util.Scanner;

/**
 * The InventoryImpl class implements the Inventory interface and manages the resources of the coffee machine.
 */
public class InventoryImpl implements Inventory {
    private static final Scanner scanner = new Scanner(System.in);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    /**
     * Constructs an InventoryImpl object with the initial resources.
     */
    public InventoryImpl() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
    }

    @Override
    public void displayResources() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money"); // TODO: Internalize the money symbol
    }


    @Override
    public boolean hasEnoughResources(CoffeeType coffeeType) {
        return water >= coffeeType.getWaterRequired()
                && milk >= coffeeType.getMilkRequired()
                && coffeeBeans >= coffeeType.getCoffeeBeansRequired()
                && cups >= 1;
    }

    @Override
    public void deductResources(CoffeeType coffeeType) {
        water -= coffeeType.getWaterRequired();
        milk -= coffeeType.getMilkRequired();
        coffeeBeans -= coffeeType.getCoffeeBeansRequired();
        cups--;
        money += coffeeType.getCost();
    }

    @Override
    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
    }

    @Override
    public void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
