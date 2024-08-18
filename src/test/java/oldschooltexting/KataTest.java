package oldschooltexting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    private static void testing_send(String input, String expected) {
        String actual = Kata.sendMessage(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(KataTest.KataTestCases.class)
    void sendMessage(KataTest.KataTestCases testCase) {
        assertEquals(testCase.expected, Kata.sendMessage(testCase.input), testCase.name());
    }

    @Test
    public void sampleTests() {
        testing_send("hey", "4433999");
        testing_send("one two three", "666 6633089666084477733 33");
        testing_send("Hello World!", "#44#33555 5556660#9#66677755531111");
        testing_send("Def Con 1!", "#3#33 3330#222#666 6601-1111");
        testing_send("A-z", "#2**#9999");
        testing_send("1984", "1-9-8-4-");
        testing_send("Big thanks for checking out my kata", "#22#444 4084426655777703336667770222443322255444664066688 806999055282");
    }

    public enum KataTestCases {
        NULL_STRING("", null),
        EMPTY_STRING("", ""),
        ACTIVATE_CAPS_SINGLE("", "#"),
        ACTIVATE_CAPS_MULTIPLE("", "####"),
        SINGLE_CHAR_A_LOWERCASE("a", "2"),
        SINGLE_CHAR_B_LOWERCASE("b", "22"),
        SINGLE_CHAR_C_LOWERCASE("c", "222"),
        SINGLE_CHAR_A_UPPPERCASE("A", "#2"),
        SINGLE_CHAR_B_UPPERCASE("B", "#22"),
        SINGLE_CHAR_C_UPPERCASE("C", "#222"),
        SINGLE_NUMBER("2", "2-"),
        HEY("hey", "4433999"),
        HEY_UPPERCASE("HEY", "#4433999"),
        HEY_UPPERCASE_WITH_SPACE("HEY ", "#44339990"),
        HEY_UPPERCASE_WITH_SPACE_AND_EXCLAMATION("HEY !", "#443399901111"),
        HEY_UPPERCASE_WITH_SPACE_AND_EXCLAMATION_AND_QUESTION("HEY !?", "#443399901111 111"),
        HEY_UPPERCASE_WITH_SPACE_AND_EXCLAMATION_AND_QUESTION_AND_ASTERISK("HEY !?*", "#443399901111 111*-"),
        HELLO_WORLD("hello world", "4433555 5556660 96667775553"),
        HELLO_WORLD_UPPERCASE("HELLO WORLD", "#4433555 5556660 96667775553"),
        HELLO_WORLD_MIXED("HeLLo WoRLd", "#44#33#555 555#6660 #9#666#777555#3"),
        ;

        private final String expected;
        private final String input;

        KataTestCases(String expected, String input) {
            this.expected = expected;
            this.input = input;
        }
    }
}
