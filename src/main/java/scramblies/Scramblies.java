package scramblies;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        // Count the characters in str1
        final Map<String, Long> str1CharFreq =
                Arrays.stream(str1.split("", -1))
                        .parallel()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Check if str2 can be made from str1
        // Count the characters in str12
        Map<String, Long> str2CharFreq =
                Arrays.stream(str2.split("", -1))
                        .parallel()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Logic here is simple, if str1 has less of a character than str2, str2 cannot be made from str1
        return str2CharFreq.entrySet().stream()
                .allMatch(e -> str1CharFreq.getOrDefault(e.getKey(), 0L) >= e.getValue());
    }
}
