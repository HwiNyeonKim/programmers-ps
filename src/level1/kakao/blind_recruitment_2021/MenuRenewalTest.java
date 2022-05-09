package level1.kakao.blind_recruitment_2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuRenewalTest {
    MenuRenewal obj = new MenuRenewal();

    @Test
    void solution1() {
        assertArrayEquals(new String[] {"AC", "ACDE", "BCFG", "CDE"},
                obj.solution(
                        new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                        new int[] {2, 3, 4}
                )
        );
    }

    @Test
    void solution2() {
        assertArrayEquals(new String[] {"ACD", "AD", "ADE", "CD", "XYZ"},
                obj.solution(
                        new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                        new int[] {2, 3, 5}
                )
        );
    }

    @Test
    void solution3() {
        assertArrayEquals(new String[] {"WX", "XY"},
                obj.solution(
                        new String[] {"XYZ", "XWY", "WXA"},
                        new int[] {2, 3, 4}
                )
        );
    }
}