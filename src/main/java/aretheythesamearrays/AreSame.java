package aretheythesamearrays;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        return a == null || b == null || a.length != b.length || check(a, b);
    }

    private static boolean check(int[] a, int[] b) {
        return false;
    }
}
