package numberofbitsofaninteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfBitsOfBinaryFromInteger {
    public static void main(String[] args) {
        extracted(1234);
        extracted(4);
        extracted(7);
    }

    private static void extracted(int num) {
        int n = numberOfBits(num);
        System.out.println(n);
    }


    private static int numberOfBits(int num) {
        List<Integer> remainders = new ArrayList<>();
        while(num > 0){
            remainders.add(num % 2);
            num /= 2;
        }
        Collections.reverse(remainders);
        return Math.toIntExact(remainders.stream().filter(n -> n > 0).count());
    }
}
