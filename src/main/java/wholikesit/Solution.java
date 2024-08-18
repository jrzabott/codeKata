package wholikesit;

public class Solution {

    public static String whoLikesIt(String... names) {
        if (names == null || names.length == 0) return "no one likes this";

        return switch (names.length) {
            case 1 -> names[0] + " likes this";
            case 2 -> names[0] + " and " + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        };
    }
}
