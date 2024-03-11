package statePattern;

public class NormalState implements MachineState {
    @Override
    public void buy(Coffee coffee, MachineInventory inventory) {
        if (inventory.hasEnoughResources(coffee)) {
            inventory.deductResources(coffee);
            inventory.addMoney(coffee.price());
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    @Override
    public void fill(MachineInventory inventory, int water, int milk, int coffeeBeans, int cups) {
        inventory.addWater(water);
        inventory.addMilk(milk);
        inventory.addCoffeeBeans(coffeeBeans);
        inventory.addCups(cups);
    }

    @Override
    public void take(MachineInventory inventory) {
        System.out.printf("I gave you $%d\n", inventory.takeMoney());
    }
}
