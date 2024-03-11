package statePattern;

interface MachineState {
    void buy(Coffee coffee, MachineInventory inventory);
    void fill(MachineInventory inventory, int water, int milk, int coffeeBeans, int cups);
    void take(MachineInventory inventory);
}
