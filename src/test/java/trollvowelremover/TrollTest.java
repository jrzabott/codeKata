package trollvowelremover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrollTest {

    public static final String THIS_WEBSITE_IS_FOR_LOSERS_LOL = "This website is for losers LOL!";
    public static final String NO_OFFENSE_BUT_YOUR_WRITING_IS_AMONG_THE_WORST_I_VE_EVER_READ = "No offense but,\nYour writing is among the worst I've ever read";
    public static final String WHAT_ARE_YOU_A_COMMUNIST = "What are you, a communist?";
    public static final String THS_WBST_S_FR_LSRS_LL = "Ths wbst s fr lsrs LL!";
    public static final String N_FFNS_BT_YR_WRTNG_S_MNG_TH_WRST_V_VR_RD = "N ffns bt,\nYr wrtng s mng th wrst 'v vr rd";
    public static final String WHT_R_Y_CMMNST = "Wht r y,  cmmnst?";

    @Test
    void solveUsingSet() {
        assertThat(Troll.solveUsingSet(THIS_WEBSITE_IS_FOR_LOSERS_LOL)).isEqualTo(THS_WBST_S_FR_LSRS_LL);
        assertThat(Troll.solveUsingSet(NO_OFFENSE_BUT_YOUR_WRITING_IS_AMONG_THE_WORST_I_VE_EVER_READ)).isEqualTo(N_FFNS_BT_YR_WRTNG_S_MNG_TH_WRST_V_VR_RD);
        assertThat(Troll.solveUsingSet(WHAT_ARE_YOU_A_COMMUNIST)).isEqualTo(WHT_R_Y_CMMNST);
    }

    @Test
    void solveUsingTreeMap() {
        assertThat(Troll.solveUsingTreeMap(THIS_WEBSITE_IS_FOR_LOSERS_LOL)).isEqualTo(THS_WBST_S_FR_LSRS_LL);
        assertThat(Troll.solveUsingTreeMap(NO_OFFENSE_BUT_YOUR_WRITING_IS_AMONG_THE_WORST_I_VE_EVER_READ)).isEqualTo(N_FFNS_BT_YR_WRTNG_S_MNG_TH_WRST_V_VR_RD);
        assertThat(Troll.solveUsingTreeMap(WHAT_ARE_YOU_A_COMMUNIST)).isEqualTo(WHT_R_Y_CMMNST);

    }

    @Test
    void solveMappingFromStringToList() {
        assertThat(Troll.solveMappingFromStringToList(THIS_WEBSITE_IS_FOR_LOSERS_LOL)).isEqualTo(THS_WBST_S_FR_LSRS_LL);
        assertThat(Troll.solveMappingFromStringToList(NO_OFFENSE_BUT_YOUR_WRITING_IS_AMONG_THE_WORST_I_VE_EVER_READ)).isEqualTo(N_FFNS_BT_YR_WRTNG_S_MNG_TH_WRST_V_VR_RD);
        assertThat(Troll.solveMappingFromStringToList(WHAT_ARE_YOU_A_COMMUNIST)).isEqualTo(WHT_R_Y_CMMNST);
    }

    @Test
    void solveWithoutUsingCapitalizationNormalization() {
        assertThat(Troll.solveWithoutUsingCapitalizationNormalization(THIS_WEBSITE_IS_FOR_LOSERS_LOL)).isEqualTo(THS_WBST_S_FR_LSRS_LL);
        assertThat(Troll.solveWithoutUsingCapitalizationNormalization(NO_OFFENSE_BUT_YOUR_WRITING_IS_AMONG_THE_WORST_I_VE_EVER_READ)).isEqualTo(N_FFNS_BT_YR_WRTNG_S_MNG_TH_WRST_V_VR_RD);
        assertThat(Troll.solveWithoutUsingCapitalizationNormalization(WHAT_ARE_YOU_A_COMMUNIST)).isEqualTo(WHT_R_Y_CMMNST);
    }

}
