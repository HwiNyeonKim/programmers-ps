package level3.dfs_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertWordsTest {
    ConvertWords obj = new ConvertWords();

    @Test
    void solution1() {
        assertEquals(4, obj.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    @Test
    void solution2() {
        assertEquals(0, obj.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
    }
}