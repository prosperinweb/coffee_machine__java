package machine.command;

import machine.MachineInventory;

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
