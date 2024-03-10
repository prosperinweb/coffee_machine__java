package machine.command;

import machine.MachineInventory;

public class BuyCommand implements Command {
    private final MachineInventory machineInventory;

    public BuyCommand(MachineInventory machineInventory) {
        this.machineInventory = machineInventory;
    }

    @Override
    public void execute() {
        this.machineInventory.buy();
    }
}
