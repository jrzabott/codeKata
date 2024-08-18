package narcisisticnumber;

public class NumberUtils {

    public static boolean isNarcissistic(int number) {
        int tempNumber = number;
        int sum = 0;
        int digitCounter = countDigits(number);

        do {
            int digit = tempNumber % 10;
            sum += Math.pow(digit, digitCounter);
            tempNumber /= 10;
        } while (tempNumber > 0);

        System.out.println("sum: " + sum + " number: " + number);

        return sum == number;
    }

    private static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}
