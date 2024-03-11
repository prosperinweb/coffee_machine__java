package commandPattern.command;

import commandPattern.MachineInventory;

public class RemainingCommand implements Command {
    private final MachineInventory machineInventory;

    public RemainingCommand(MachineInventory machineInventory) {
        this.machineInventory = machineInventory;
    }

    @Override
    public void execute() {
        this.machineInventory.remaining();
    }
}
