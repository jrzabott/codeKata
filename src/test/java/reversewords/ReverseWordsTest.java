package reversewords;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsTest {

    public static final String THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG = "The quick brown fox jumps over the lazy dog.";
    public static final String EH_T_KCIUQ_NWORB_XOF_SPMUJ_REVO_EHT_YZAL_GOD = "ehT kciuq nworb xof spmuj revo eht yzal .god";
    public static final String APPLE = "apple";
    public static final String ELPPA = "elppa";
    public static final String A_B_C_D = "a b c d";
    public static final String ELBUOD_DECAPS_SDROW = "elbuod  decaps  sdrow";
    public static final String DOUBLE_SPACED_WORDS = "double  spaced  words";

    @Test
    void reverseWords() {
        assertThat(ReverseWords.reverseWords(THE_QUICK_BROWN_FOX_JUMPS_OVER_THE_LAZY_DOG)).isEqualTo(EH_T_KCIUQ_NWORB_XOF_SPMUJ_REVO_EHT_YZAL_GOD);
        assertThat(ReverseWords.reverseWords(APPLE)).isEqualTo(ELPPA);
        assertThat(ReverseWords.reverseWords(A_B_C_D)).isEqualTo(A_B_C_D);
        assertThat(ReverseWords.reverseWords(ELBUOD_DECAPS_SDROW)).isEqualTo(DOUBLE_SPACED_WORDS);
    }
}