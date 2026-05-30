class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int m, n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        //DFS on everycell and check whether it can reach the pacific and atlantic ocean
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(i, j, visited, heights[i][j], new boolean[2])) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public boolean dfs(int r, int c, boolean[][] visited, int prevHeight, boolean[] ocean) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        if (visited[r][c])
            return false;
        if (heights[r][c] > prevHeight)
            return false;
        visited[r][c] = true;

        if (r == 0 || c == 0)
            ocean[0] = true;
        if (r == m - 1 || c == n - 1)
            ocean[1] = true;

        if (ocean[0] && ocean[1])
            return true;
        dfs(r + 1, c, visited, heights[r][c], ocean);
        dfs(r - 1, c, visited, heights[r][c], ocean);
        dfs(r, c + 1, visited, heights[r][c], ocean);
        dfs(r, c - 1, visited, heights[r][c], ocean);

        return ocean[0] && ocean[1];
    }
}