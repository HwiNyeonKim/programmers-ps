package dfs_bfs;

public class Network {
    public int solution(int n, int[][] computers) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1) {
                dfs(computers, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] computers, int i) {
        if (i < 0 || i >= computers.length || computers[i][i] != 1) {
            return;
        }

        computers[i][i] = 7; // mark as visited

        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1) {
                dfs(computers, j);
            }
        }
    }
}
