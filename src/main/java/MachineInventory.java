import java.util.Scanner;

public class MachineInventory {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private boolean isRunning = true;

    public MachineInventory(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public MachineInventory() {
        this(400, 540, 120, 9, 550);
    }

    public void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", this.water);
        System.out.printf("%d of milk\n", this.milk);
        System.out.printf("%d of coffee beans\n", this.coffeeBeans);
        System.out.printf("%d of disposable cups\n", this.cups);
        System.out.printf("%d of money\n", this.money);
    }

    public void buy(String coffeeType) {
        switch (coffeeType) {
            case "1":
                this.buyEspresso();
                break;
            case "2":
                this.buyLatte();
                break;
            case "3":
                this.buyCappuccino();
                break;
            default:
                break;
        }
    }

    private void buyEspresso() {
        if (this.water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (this.coffeeBeans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 250;
            this.coffeeBeans -= 16;
            this.cups -= 1;
            this.money += 4;
        }
    }

    private void buyLatte() {
        if (this.water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < 20) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 350;
            this.milk -= 75;
            this.coffeeBeans -= 20;
            this.cups -= 1;
            this.money += 7;
        }
    }

    private void buyCappuccino() {
        if (this.water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= 200;
            this.milk -= 100;
            this.coffeeBeans -= 12;
            this.cups -= 1;
            this.money += 6;
        }
    }

    public void fill(int water, int milk, int coffeeBeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.cups += cups;
    }

    public void take() {
        System.out.printf("I gave you $%d\n", this.money);
        this.money = 0;
    }

    public void executeAction(String action) {
        switch (action) {
            case "buy":
                this.buy();
                break;
            case "fill":
                this.fill();
                break;
            case "take":
                this.take();
                break;
            case "remaining":
                this.printInventory();
                break;
            case "exit":
                this.isRunning = false;
                break;
            default:
                break;
        }
    }

    private void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        this.buy(scanner.next());
    }

    private void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        this.fill(water, milk, coffeeBeans, cups);
    }

    public boolean isRunning() {
        return isRunning;
    }
}

