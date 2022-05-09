package level1.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersNotFinishedTest {
    PlayersNotFinished obj = new PlayersNotFinished();

    @Test
    void solution1() {
        assertEquals("leo", obj.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }

    @Test
    void solution2() {
        assertEquals("vinko", obj.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] {"josipa", "filipa", "marina", "nikola"}));
    }

    @Test
    void solution3() {
        assertEquals("mislav", obj.solution(new String[] {"mislav", "stanko", "mislav", "ana"},
                new String[] {"stanko", "ana", "mislav"}));
    }
}