package tipstown2017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemovingPairedStringTest {
    RemovingPairedString obj = new RemovingPairedString();

    @Test
    void solution() {
        assertEquals(1, obj.solution("baabaa"));
        assertEquals(0, obj.solution("cdcd"));
    }
}