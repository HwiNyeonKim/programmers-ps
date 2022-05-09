package level3.kakao.blind_recruitment_2019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateKeyTest {
    CandidateKey obj = new CandidateKey();

    @Test
    void solution() {
        assertEquals(2, obj.solution(new String[][] {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        }));
    }
}