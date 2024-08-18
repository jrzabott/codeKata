package oldschooltexting;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class simulates typing on an old mobile phone with a 3x4 key layout, similar to the old feature phones before the era of smartphones.
 * The goal is to convert a given message into a sequence of keypresses that would produce the same message on such a device.
 *
 * <p>If you're old enough, you might remember buying your first mobile phone, one of the old ones with no touchscreen, and sending
 * your first text message with excitement in your eyes. Maybe you still have one lying in a drawer somewhere.</p>
 *
 * <p>Let's try to remember the good old days and what it was like to send text messages with such devices. A lot of them had different
 * layouts, most notably for special characters and spaces, so for simplicity we'll be using a fictional model with a 3x4 key layout shown below:</p>
 *
 * <pre>
 * -------------------------
 * |   1   |   2   |   3   |  <-- hold a key to type a number
 * |  .,?! |  abc  |  def  |  <-- press a key to type a letter
 * -------------------------
 * |   4   |   5   |   6   |  <-- Top row
 * |  ghi  |  jkl  |  mno  |  <-- Bottom row
 * -------------------------
 * |   7   |   8   |   9   |
 * |  pqrs |  tuv  |  wxyz |
 * -------------------------
 * |   *   |   0   |   #   |  <-- hold for *, 0 or #
 * |  '-+= | space |  case |  <-- press # to switch between upper/lower case
 * -------------------------
 * </pre>
 *
 * <h3>The task</h3>
 * <p>
 * You will receive a message, and your job is to figure out which keys you need to press to output the given message with the lowest
 * number of clicks possible. Return the result as a string of key inputs from the top row (refer to diagram above).
 * </p>
 *
 * <h3>How it works:</h3>
 * <ul>
 *   <li><strong>Result:</strong> The output string contains inputs that are shown at the top row of a key's layout (0-9, *, #).</li>
 *   <li><strong>Typing letters:</strong> Press a button repeatedly to cycle through the possible characters (bottom row of a key's layout).
 *     Pressing is represented by the key's top row element repeated n times, where n is the position of the character on that particular key.
 *     Examples:
 *     <ul>
 *       <li>2 => 'a'</li>
 *       <li>9999 => 'z'</li>
 *       <li>111 => '?'</li>
 *       <li>*** => '+' </li>
 *     </ul>
 *   </li>
 *   <li><strong>Typing numbers:</strong> To type numbers 0-9 and special characters *, # - hold that key.
 *     Holding is represented by a number followed by a dash. Examples:
 *     <ul>
 *       <li>3- => '3'</li>
 *       <li>5-5-5- => '555'</li>
 *     </ul>
 *   </li>
 *   <li><strong>Uppercase / Lowercase:</strong> Initially, the case is lowercase.
 *     To toggle between lowercase and uppercase letters, use the # symbol. Case switching only applies when the next character is alphabetic (a-z).
 *     Examples:
 *     <ul>
 *       <li>#2#9999 => 'Az'</li>
 *       <li>27-#2255 => 'a7BK'</li>
 *     </ul>
 *   </li>
 *   <li><strong>Waiting for next character:</strong> If you have 2 or more characters in a sequence that reside on the same button (refer to layout, bottom row),
 *     you have to wait before pressing the same button again. Waiting is represented by adding a space between 2 (or more) such characters. Example:
 *     <ul>
 *       <li>44 444 44 444 => 'hihi'</li>
 *     </ul>
 *     Exceptions: No need to wait after holding any key, even if the next character resides on the same button (4-4 => '4g'),
 *     or if there's a case switch between two characters on the same button (#5#55 => 'Jk').
 *   </li>
 * </ul>
 *
 * <h3>Example:</h3>
 * Let's go over an example for the message "Def Con 1!":
 * <ol>
 *   <li>Switch to uppercase with # and press 3 (#3 => D) (input is now in uppercase mode).</li>
 *   <li>Switch to lowercase and press 3 twice (#33 => e). (No waiting required due to case switching).</li>
 *   <li>Next character 'f' is on button 3 again, so you have to wait (' 333' => f).</li>
 *   <li>Similarly, type the second word. (Space is on number 0). 0#222#666 660 => ' Con '.</li>
 *   <li>Finish with holding 1 as 1- and typing ! as 1111 ('1-1111' => 1!).</li>
 * </ol>
 * <p>
 * Result for "Def Con 1!":
 * <pre>sendMessage("Def Con 1!") => "#3#33 3330#222#666 6601-1111"</pre>
 *
 * <h3>Note:</h3>
 * All inputs are valid strings and only consist of characters from the key layout table.
 */

public class Kata {

    private static final Decoder decoder = new Kata.Decoder();

    private Kata() {
        throw new IllegalStateException("Utility class");
    }

    public static String sendMessage(String message) {
//        return decodeMessage(message);
        return encodeMessage(message);
    }

    private static String decodeMessage(String message) {
        return decoder.decode(message);
    }

    public static String encodeMessage(String message) {
        return decoder.encode(message);
    }

    private static class Decoder {
        private final Map<Character, String[]> CHARACTERS;
        private final Map<Character, String> REVERSE_CHARACTERS;
        /**
         * This flag is used to keep track of the current case mode.
         * If true, the next character should be in uppercase.
         * Default is false (lowercase).
         */
        private boolean isUpperCaseMode = false;

        private Decoder() {
            CHARACTERS = initializeCharactersMap();
            REVERSE_CHARACTERS = initializeReverseCharactersMap();
        }

        private Map<Character, String> initializeReverseCharactersMap() {
            Map<Character, String> reverseMap = new HashMap<>();

            for (Map.Entry<Character, String[]> entry : CHARACTERS.entrySet()) {
                char key = entry.getKey();
                String[] values = entry.getValue();

                for (int i = 0; i < values.length; i++) {
                    reverseMap.put(values[i].charAt(0), String.valueOf(key).repeat(i + 1));
                }
            }
            reverseMap.put('1', "1-");
            reverseMap.put('2', "2-");
            reverseMap.put('3', "3-");
            reverseMap.put('4', "4-");
            reverseMap.put('5', "5-");
            reverseMap.put('6', "6-");
            reverseMap.put('7', "7-");
            reverseMap.put('8', "8-");
            reverseMap.put('9', "9-");
            reverseMap.put('0', "0-");
            reverseMap.put(' ', "0");
            return reverseMap;
        }

        private Map<Character, String[]> initializeCharactersMap() {
            Map<Character, String[]> characters = new HashMap<>();
            characters.put('1', new String[]{".", ",", "?", "!"});
            characters.put('2', new String[]{"a", "b", "c"});
            characters.put('3', new String[]{"d", "e", "f"});
            characters.put('4', new String[]{"g", "h", "i"});
            characters.put('5', new String[]{"j", "k", "l"});
            characters.put('6', new String[]{"m", "n", "o"});
            characters.put('7', new String[]{"p", "q", "r", "s"});
            characters.put('8', new String[]{"t", "u", "v"});
            characters.put('9', new String[]{"w", "x", "y", "z"});
            characters.put('0', new String[]{" "});
            characters.put('*', new String[]{"'", "-", "+", "="});
            return Collections.unmodifiableMap(characters);
        }

        public String decode(String message) {
            if (StringUtils.isBlank(message)) {
                return StringUtils.EMPTY;
            }

            message = StringUtils.trim(message);
            StringBuilder result = new StringBuilder();
            char lastKeyPressed = '\0';
            byte keyPressCount = 0;

            for (int i = 0; i < message.length(); i++) {
                char currentChar = message.charAt(i);
                if (Character.isDigit(currentChar) || currentChar == '*') {
                    // process character
                    if (lastKeyPressed == currentChar) {
                        keyPressCount++;
                        continue;
                    }

                    result.append(processKeyPress(lastKeyPressed, keyPressCount));
                    keyPressCount = 1;
                    lastKeyPressed = currentChar;
                }

                if (currentChar == '#') { // switch case
                    // Process any buffered character before changing the case
                    if (lastKeyPressed != '\0') {
                        result.append(processKeyPress(lastKeyPressed, keyPressCount));
                        lastKeyPressed = '\0';
                        keyPressCount = 0;
                    }
                    isUpperCaseMode = !isUpperCaseMode;
                    continue;
                }

                if (currentChar == ' ') {
                    // process pressed key as number
                    result.append(processKeyPress(lastKeyPressed, keyPressCount));
                    lastKeyPressed = '\0'; // reset last key
                    keyPressCount = 0;
                    continue;
                }

                if (currentChar == '-') {
                    // log press should treat this a number
                    result.append(lastKeyPressed);
                    keyPressCount = 0;
                    lastKeyPressed = '\0';
                    continue;
                }

            }

            result.append(processKeyPress(lastKeyPressed, keyPressCount));
            // process the last character and turn off uppercase mode
            isUpperCaseMode = false;
            return result.toString();
        }

        private String processKeyPress(char lastKeyPressed, byte keyPressCount) {
            if (lastKeyPressed == '\0' || !CHARACTERS.containsKey(lastKeyPressed)) {
                return StringUtils.EMPTY;
            }

            String[] possibleChars = CHARACTERS.get(lastKeyPressed);
            int index = (keyPressCount - 1) % possibleChars.length;
            String decodedLetter = possibleChars[index];

            if (isUpperCaseMode) {
                decodedLetter = decodedLetter.toUpperCase();
            }

            return decodedLetter;
        }

        public String encode(String message) {
            if (message == null || message.isEmpty()) {
                return "";
            }

            StringBuilder result = new StringBuilder();
            boolean isUpperCaseActive = false;
            char lastKeyPressed = '\0';

            for (int i = 0; i < message.length(); i++) {
                char currentChar = message.charAt(i);

                // Handle uppercase letters
                if (Character.isUpperCase(currentChar)) {
                    if (!isUpperCaseActive) {
                        result.append("#");
                        isUpperCaseActive = true;
                    }
                } else if (isUpperCaseActive) {
                    // If we were in uppercase mode, switch back to lowercase
                    result.append("#");
                    lastKeyPressed = '#';
                    isUpperCaseActive = false;
                }

                // Convert to lowercase for lookup
                char charToProcess = Character.toLowerCase(currentChar);

                // Get the corresponding keypresses from the map
                String keypresses = REVERSE_CHARACTERS.get(charToProcess);

                if (keypresses == null) {
                    throw new IllegalArgumentException("Unsupported character: " + currentChar);
                }
                if (keypresses.endsWith("-"))
                    lastKeyPressed = '\0';

                // Handle wait logic (insert space if the last key was the same as the current key)
                if (lastKeyPressed != '\0'
                        && keypresses.charAt(0) == lastKeyPressed
                        && lastKeyPressed != '#'
                        && lastKeyPressed != '0') {
                    result.append(" ");
                }

                // Append the keypresses
                result.append(keypresses);

                // Update the last key pressed
                lastKeyPressed = keypresses.endsWith("-") ? lastKeyPressed : keypresses.charAt(0);
            }

            return result.toString();
        }


    }
}
