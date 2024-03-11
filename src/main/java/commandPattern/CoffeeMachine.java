package commandPattern;

import commandPattern.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static commandPattern.MachineCommand.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineInventory machineInventory = new MachineInventory();

        Map<MachineCommand, Command> commands = new HashMap<>();
        commands.put(BUY, new BuyCommand(machineInventory));
        commands.put(FILL, new FillCommand(machineInventory));
        commands.put(TAKE, new TakeCommand(machineInventory));
        commands.put(REMAINING, new RemainingCommand(machineInventory));
        commands.put(EXIT, new ExitCommand(machineInventory));

        while (machineInventory.isRunning()) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            MachineCommand action = MachineCommand.valueOf(scanner.next().toUpperCase());

            Command command = commands.get(action);
            if (command != null) {
                command.execute();
            }
        }
    }
}
