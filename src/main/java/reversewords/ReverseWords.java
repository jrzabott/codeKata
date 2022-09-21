package reversewords;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWords {

    public static String reverseWords(String original) {
        List<Integer> spaceIndexes = new ArrayList<>();

        // Have at it
        final char[] chars = original.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                spaceIndexes.add(i);
        }
        final List<String> reversedWords = Stream.of(original.split(" ")).map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.toList());
        final String collect = String.join("", reversedWords);
        List<Character> reversedCharsList = new ArrayList<>();
        for (int j = 0; j < collect.length(); j++) {
            reversedCharsList.add(collect.charAt(j));
        }
        for (Integer spaceIndex : spaceIndexes) {
            reversedCharsList.add(spaceIndex, ' ');
        }

        return reversedCharsList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("\"" + reverseWords(" a batata tadinha     .") + "\"");
    }
}
