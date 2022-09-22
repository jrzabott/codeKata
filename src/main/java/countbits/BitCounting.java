package countbits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
 * <p>
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */
public class BitCounting {

    private BitCounting() {
    }

    public static int countBits(int n) {
        // Show me the code!
        List<Integer> remainders = new ArrayList<>();
        while (n > 0) {
            remainders.add(n % 2);
            n /= 2;
        }
        Collections.reverse(remainders);
        return Math.toIntExact(remainders.stream().filter(x -> x > 0).count());
    }
}
