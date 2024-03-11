package commandPattern;

public enum MachineSelection {
    ESPRESSO,
    LATTE,
    CAPPUCCINO,
    BACK;

    public static <T> MachineSelection fromValue(T value) {
        if (value instanceof Integer integer) {
            return switch (integer) {
                case 1 -> ESPRESSO;
                case 2 -> LATTE;
                case 3 -> CAPPUCCINO;
                default -> null;
            };
        } else if (value instanceof String str && str.equalsIgnoreCase("back")) {
            return BACK;
        } else {
            return null;
        }
    }

    public static String getSelectionPrompt() {
        StringBuilder prompt = new StringBuilder("What do you want to buy? ");
        MachineSelection[] values = MachineSelection.values();
        for (int i = 0; i < values.length - 1; i++) {
            MachineSelection selection = values[i];
            prompt.append(i + 1).append(" - ").append(selection.name().toLowerCase()).append(", ");
        }
        prompt.append("back - to main menu:");
        return prompt.toString();
    }
}