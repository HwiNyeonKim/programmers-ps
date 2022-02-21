package kakao2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptingReportResultTest {
    AcceptingReportResult obj = new AcceptingReportResult();

    @Test
    void solution1() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Assertions.assertArrayEquals(
                new int[] {2, 1, 1, 0},
                obj.solution(id_list, reports, k)
        );
    }

    @Test
    void soluion2() {
        String[] id_list = {"con", "ryan"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        Assertions.assertArrayEquals(
                new int[]{0, 0},
                obj.solution(id_list, reports, k));
    }
}