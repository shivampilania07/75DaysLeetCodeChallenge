class Pair {
    int first;
    int second;
    int tm;

    Pair(int first, int second, int tm) {
        this.first = first;
        this.second = second;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minute = 0;
        int[][] vis = new int[m][n];
        int cntfresh = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1)
                    cntfresh++;
            }
        }

        int tm = 0;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int cnt = 0;
        while (!queue.isEmpty()) {
            int r = queue.peek().first;
            int c = queue.peek().second;
            int t = queue.peek().tm;
            tm = Math.max(tm, t);
            queue.remove();

            for (int k = 0; k < 4; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }

        }

        if (cnt != cntfresh)
            return -1;
        return tm;

    }
}