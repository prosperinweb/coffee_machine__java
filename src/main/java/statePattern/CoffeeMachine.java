package statePattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineInventory machineInventory = new MachineInventory();
        Map<String, Coffee> coffeeTypes = new HashMap<>();
        coffeeTypes.put("1", new Coffee("Espresso", 250, 0, 16, 4));
        coffeeTypes.put("2", new Coffee("Latte", 350, 75, 20, 7));
        coffeeTypes.put("3", new Coffee("Cappuccino", 200, 100, 12, 6));

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String coffeeType = scanner.next();
                Coffee coffee = coffeeTypes.get(coffeeType);
                if (coffee != null) {
                    machineInventory.executeAction(action, coffee, 0, 0, 0, 0);
                } else {
                    System.out.println("Invalid coffee type!");
                }
            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add:");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int coffeeBeans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = scanner.nextInt();
                machineInventory.executeAction(action, null, water, milk, coffeeBeans, cups);
            } else if (action.equals("take") || action.equals("remaining")) {
                machineInventory.executeAction(action, null, 0, 0, 0, 0);
            } else if (action.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid action!");
            }
        }
    }
}
