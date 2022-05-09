package level3.dfs_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelRouteTest {
    TravelRoute obj = new TravelRoute();

    @Test
    void solution1() {
        assertArrayEquals(new String[] {"ICN", "JFK", "HND", "IAD"}, obj.solution(new String[][] {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        }));
    }

    @Test
    void solution2() {
        assertArrayEquals(new String[] {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, obj.solution(new String[][] {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}
        }));
    }

    @Test
    void solution3() {
        assertArrayEquals(new String[] {"ICN", "AAA", "ICN", "AAA", "ICN", "AAA"}, obj.solution(new String[][] {
                {"ICN","AAA"},
                {"ICN","AAA"},
                {"ICN","AAA"},
                {"AAA","ICN"},
                {"AAA","ICN"}
        }));
    }

    @Test
    void solution4() {
        assertArrayEquals(new String[] {"ICN", "B", "ICN", "A"}, obj.solution(new String[][] {
                {"ICN", "A"},
                {"ICN", "B"},
                {"B", "ICN"}
        }));
    }

    @Test
    void solution5() {
        assertArrayEquals(new String[] {"ICN", "A", "ICN", "A", "C"}, obj.solution(new String[][] {
                {"ICN", "A"},
                {"ICN", "A"},
                {"A", "ICN"},
                {"A", "C"}
        }));
    }

    @Test
    void solution6() {
        assertArrayEquals(new String[] {"ICN", "JFK", "HND", "IAD", "JFK", "IAD"}, obj.solution(new String[][] {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"},
                {"IAD", "JFK"},
                {"JFK", "IAD"}
        }));
    }

}