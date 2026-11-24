public class Solution {
    private int max;
    private int rows, cols;
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, visited, i, j, 0);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, boolean[][] visited, int r, int c, int current) {
        current += grid[r][c];
        if (current > max) max = current;
        visited[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] > 0 && !visited[nr][nc]) {
                dfs(grid, visited, nr, nc, current);
            }
        }
        visited[r][c] = false;
    }
}
