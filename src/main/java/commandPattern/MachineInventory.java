package commandPattern;

import java.util.Scanner;

import static commandPattern.MachineStock.*;

public class MachineInventory {
    private boolean isRunning = true;

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of %s%n", WATER.getAmount(), WATER.getName());
        System.out.printf("%d ml of %s%n", MILK.getAmount(), MILK.getName());
        System.out.printf("%d g of %s%n", COFFEE_BEANS.getAmount(), COFFEE_BEANS.getName());
        System.out.printf("%d %s%n", CUPS.getAmount(), CUPS.getName());
        System.out.printf("$%d of %s%n", MONEY.getAmount(), MONEY.getName());
    }

    public void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MachineSelection.getSelectionPrompt());
        String input = scanner.next();

        MachineSelection selection;
        if (input.matches("\\d+")) {
            selection = MachineSelection.fromValue(Integer.parseInt(input));
        } else {
            selection = MachineSelection.fromValue(input);
        }

        if (selection == null) {
            System.out.println("Invalid selection");
            return;
        }

        switch (selection) {
            case ESPRESSO -> buyEspresso();
            case LATTE -> buyLatte();
            case CAPPUCCINO -> buyCappuccino();
            case BACK -> {}
        }
    }

    private void buyEspresso() {
        if (WATER.getAmount() >= 250 && COFFEE_BEANS.getAmount() >= 16 && CUPS.getAmount() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            WATER.deductAmount(250);
            COFFEE_BEANS.deductAmount(16);
            CUPS.deductAmount(1);
            MONEY.addAmount(4);
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void buyLatte() {
        if (WATER.getAmount() >= 350 && MILK.getAmount() >= 75 && COFFEE_BEANS.getAmount() >= 20 && CUPS.getAmount() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            WATER.deductAmount(350);
            MILK.deductAmount(75);
            COFFEE_BEANS.deductAmount(20);
            CUPS.deductAmount(1);
            MONEY.addAmount(7);
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void buyCappuccino() {
        if (WATER.getAmount() >= 200 && MILK.getAmount() >= 100 && COFFEE_BEANS.getAmount() >= 12 && CUPS.getAmount() >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            WATER.deductAmount(200);
            MILK.deductAmount(100);
            COFFEE_BEANS.deductAmount(12);
            CUPS.deductAmount(1);
            MONEY.addAmount(6);
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        WATER.addAmount(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        MILK.addAmount(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        COFFEE_BEANS.addAmount(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        CUPS.addAmount(scanner.nextInt());
    }

    public void take() {
        System.out.printf("I gave you $%d\n", MONEY.getAmount());
        MONEY.setAmount(0);
    }

    public void exit() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
