package level2.kakao.kakado_code_2017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TakingGroupPictureTest {
    TakingGroupPicture obj = new TakingGroupPicture();

    @Test
    void solution1() {
        assertEquals(3648, obj.solution(2, new String[] {"N~F=0", "R~T>2"}));
    }

    @Test
    void solution2() {
        assertEquals(0, obj.solution(2, new String[] {"M~C<2", "C~M>1"}));
    }
}