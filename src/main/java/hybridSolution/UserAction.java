package hybridSolution;

import java.util.Arrays;

/**
 * The UserAction enum represents the actions that a user can perform in the coffee machine application.
 */
public enum UserAction {
    BUY,
    FILL,
    TAKE,
    REMAINING,
    EXIT;

    /**
     * Converts a string input to a UserAction enum value.
     *
     * @param input The string input
     * @return The corresponding UserAction value, or null if the input is invalid
     */
    public static UserAction fromString(String input) {
        try {
            return valueOf(input);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // caching the generated user prompt
    private static final String USER_PROMPT = generateUserPrompt();

    private static String generateUserPrompt() {
        // Write action (buy, fill, take, remaining, exit):
        return "Write action (%s):".formatted(Arrays.stream(UserAction.values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .reduce((a, b) -> a + ", " + b)
                .orElse(""));
    }

    public static String getUserPrompt() {
        return USER_PROMPT;
    }
}