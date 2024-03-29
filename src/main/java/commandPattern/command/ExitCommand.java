package commandPattern.command;

import commandPattern.MachineInventory;

public class ExitCommand implements Command {
    private final MachineInventory machineInventory;

    public ExitCommand(MachineInventory machineInventory) {
        this.machineInventory = machineInventory;
    }

    @Override
    public void execute() {
        this.machineInventory.exit();
    }
}
