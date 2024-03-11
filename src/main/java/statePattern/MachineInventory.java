package statePattern;

public class MachineInventory {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;
    private final MachineState state;

    public MachineInventory() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = new NormalState();
    }

    public void executeAction(String action, Coffee coffee, int water, int milk, int coffeeBeans, int cups) {
        switch (action) {
            case "buy":
                state.buy(coffee, this);
                break;
            case "fill":
                state.fill(this, water, milk, coffeeBeans, cups);
                break;
            case "take":
                state.take(this);
                break;
            case "remaining":
                printInventory();
                break;
            case "exit":
                // Handle exit action
                break;
            default:
                System.out.println("Invalid action!");
                break;
        }
    }

    public void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", coffeeBeans);
        System.out.printf("%d of disposable cups\n", cups);
        System.out.printf("%d of money\n", money);
    }

    public boolean hasEnoughResources(Coffee coffee) {
        return water >= coffee.waterRequired()
                && milk >= coffee.milkRequired()
                && coffeeBeans >= coffee.coffeeBeansRequired()
                && cups >= 1;
    }

    public void deductResources(Coffee coffee) {
        water -= coffee.waterRequired();
        milk -= coffee.milkRequired();
        coffeeBeans -= coffee.coffeeBeansRequired();
        cups--;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void addCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans += coffeeBeans;
    }

    public void addCups(int cups) {
        this.cups += cups;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int takeMoney() {
        int moneyToTake = money;
        money = 0;
        return moneyToTake;
    }

    // Additional methods to change the state if needed
}