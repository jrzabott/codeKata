package trollvowelremover;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Code Kata with the following proposition:
 * <p>
 * Trolls are attacking your comment section!
 * A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
 * Your task is to write a function that takes a string and return a new string with all vowels removed.
 * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
 * Note: for this kata y isn't considered a vowel.
 */
public class Troll {
    private Troll() {
    }

    public static String solveUsingSet(String str) {
        final Set<String> vowels2 = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
        return new ArrayList<>(str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList())).stream().filter(c -> !vowels2.contains(c.toLowerCase())).collect(Collectors.joining());
    }


    public static String solveUsingTreeMap(String str) {
        final Map<String, String> vowels2 = new TreeMap<>(Stream.of("a", "e", "i", "o", "u").collect(Collectors.toMap(c -> c, d -> d)));
        return new ArrayList<>(str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList())).stream().filter(c -> vowels2.get(c.toLowerCase()) == null).collect(Collectors.joining());
    }

    public static String solveMappingFromStringToList(String str) {
        final List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        return new ArrayList<>(str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList())).stream().filter(c -> !vowels.contains(c.toLowerCase())).collect(Collectors.joining());
    }

    public static String solveWithoutUsingCapitalizationNormalization(String str) {
        final List<String> vowels = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
        return new ArrayList<>(str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList())).stream().filter(c -> !vowels.contains(c)).collect(Collectors.joining());
    }

}
