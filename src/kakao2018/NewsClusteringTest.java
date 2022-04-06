package kakao2018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsClusteringTest {
    NewsClustering obj = new NewsClustering();

    @Test
    void solution1() {
        assertEquals(16384, obj.solution("FRANCE", "french"));
    }

    @Test
    void solution2() {
        assertEquals(65536, obj.solution("handshake", "shake hands"));

    }

    @Test
    void solution3() {
        assertEquals(43690, obj.solution("aa1+aa2", "AAAA12"));
    }

    @Test
    void solution4() {
        assertEquals(65536, obj.solution("E=M*C^2", "e=m*c^2"));

    }
}