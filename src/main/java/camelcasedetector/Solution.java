package camelcasedetector;

import org.apache.commons.lang3.StringUtils;

class Solution {
    public static String camelCase(String input) {
        if (StringUtils.isBlank(input)) {
            return StringUtils.EMPTY;
        }

        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            result.append(shouldAddWhiteSpace(c, i, input) ? " " : "").append(c);
        }
        return result.toString();
    }

    private static boolean shouldAddWhiteSpace(char c, int i, String input) {
        return Character.isAlphabetic(c)
                && Character.isUpperCase(c)
                && Character.isAlphabetic(input.charAt(i - 1)); // previous character is not special char
    }
}
