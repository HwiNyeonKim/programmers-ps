package dfs_bfs;

public class KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int areaCount = 0;
        int areaMaxSize = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    areaCount++;
                    areaMaxSize = Math.max(areaMaxSize, dfs(visited, picture, i, j, picture[i][j]));
                }
            }
        }

        return new int[] { areaCount, areaMaxSize };
    }

    // 상하좌우 이동용
    int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private int dfs(boolean[][] visited, int[][] picture, int i, int j, int value) {
        int size = 0;
        if (i < 0 || j < 0 || i >= picture.length || j >= picture[0].length || visited[i][j]) {
            return size;
        }

        if (value == picture[i][j]) {
            size++;
            visited[i][j] = true;

            for (int[] direction : directions) {
                size += dfs(visited, picture, i + direction[0], j + direction[1], value);
            }
        }

        return size;
    }
}
