package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListOfPhoneNumbersTest {
    ListOfPhoneNumbers obj = new ListOfPhoneNumbers();

    @Test
    void solution1() {
        assertEquals(false, obj.solution(new String[] {"119", "97674223", "1195524421"}));
    }

    @Test
    void solution2() {
        assertEquals(true, obj.solution(new String[] {"123","456","789"}));
    }

    @Test
    void solution3() {
        assertEquals(false, obj.solution(new String[] {"12","123","1235","567","88"}));
    }

    @Test
    void solution4() {
        assertEquals(true, obj.solution(new String[] {"12", "235", "2345", "567", "88"}));
    }

    @Test
    void solution5() {
        assertEquals(true, obj.solution(new String[] {"113", "114", "5356", "3333", "111111", "88"}));
    }
}