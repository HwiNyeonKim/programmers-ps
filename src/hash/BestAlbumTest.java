package hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestAlbumTest {
    BestAlbum obj = new BestAlbum();

    @Test
    void solution1() {
        assertArrayEquals(new int[] {4, 1, 3, 0},
                obj.solution(new String[] {"classic", "pop", "classic", "classic", "pop"},
                        new int[] {500, 600, 150, 800, 2500}));
    }

}