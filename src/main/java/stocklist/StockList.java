package stocklist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockList {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] art, String[] cd) {

        if (art.length == 0 || cd.length == 0)
            return "";

        // Using a LinkedHashSet to maintain the order of categories
        Set<String> categories = new LinkedHashSet<>(Arrays.asList(cd)); // add all categories to set

        Map<String, Integer> stock = new HashMap<>();
        Stream.of(art)
                .filter(s -> categories.contains(s.substring(0, 1))) // filter out categories not in cd
                .map(s -> s.split(" "))// split each string into array of 2 elements
                .forEach(s -> {
                    String category = s[0].substring(0, 1); // get the category
                    int quantity = Integer.parseInt(s[1]); // get the quantity
                    stock.put(category, stock.getOrDefault(category, 0) + quantity); // commulate the quantity
                });

        return categories.stream()
                .map(c -> "(" + c + " : " + stock.getOrDefault(c, 0) + ")")
                .collect(Collectors.joining(" - "));
    }
}
