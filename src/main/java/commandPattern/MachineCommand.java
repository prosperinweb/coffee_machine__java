package commandPattern;

public enum MachineCommand {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    private final String command;

    MachineCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
