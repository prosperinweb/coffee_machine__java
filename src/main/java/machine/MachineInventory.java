package machine;

import java.util.Scanner;

public class MachineInventory {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    private int money = 550;
    private boolean isRunning = true;

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffeeBeans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
    }

    public void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
                break;
        }
    }

    private void buyEspresso() {
        if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffeeBeans -= 16;
            money += 4;
            cups -= 1;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void buyLatte() {
        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
            cups -= 1;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void buyCappuccino() {
        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
            cups -= 1;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
    }

    public void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public void exit() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
