package stringendswith;

/**
 * Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).
 * <p>
 * Examples:
 * <p>
 * solution('abc', 'bc') // returns true
 * solution('abc', 'd') // returns false
 */
public class Kata {
    private Kata() {
    }

    public static boolean solution(String str, String ending) {

        return ending != null && str != null && ending.length() <= str.length() && str.endsWith(ending);
    }
}
