package commandPattern.command;

import commandPattern.MachineInventory;

public class TakeCommand implements Command {
    private final MachineInventory machineInventory;

    public TakeCommand(MachineInventory machineInventory) {
        this.machineInventory = machineInventory;
    }

    @Override
    public void execute() {
        this.machineInventory.take();
    }
}
