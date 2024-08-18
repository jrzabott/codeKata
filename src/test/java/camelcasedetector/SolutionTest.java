package camelcasedetector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static void testing_send(String input, String expected) {
        String actual = Solution.camelCase(input);
        assertEquals(expected, actual);
    }

    @Test
    void camelCase() {
        testing_send("", "");
        testing_send(null, "");
        testing_send("camelcasing", "camelcasing");
        testing_send("camelCasing", "camel Casing");
        testing_send("camelCasingTest", "camel Casing Test");
        testing_send("camel>CasingTest", "camel>Casing Test");
        testing_send("CamelCasingTest", "Camel Casing Test");
    }

    @Test
    void aTest() {
        assertTrue(Character.isAlphabetic('<'));
    }
}
