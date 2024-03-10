package machine.command;

import machine.MachineInventory;

public class FillCommand implements Command {
    private final MachineInventory machineInventory;

    public FillCommand(MachineInventory machineInventory) {
        this.machineInventory = machineInventory;
    }

    @Override
    public void execute() {
        this.machineInventory.fill();
    }
}
