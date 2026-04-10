class Pair {
    int row;
    int col;
    int diff;

    Pair(int row, int col, int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}

class Solution {
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result)
            Arrays.fill(row, (int) 1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        pq.add(new Pair(0, 0, grid[0][0]));
        result[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.row;
            int j = curr.col;
            int diff = curr.diff;

            if (i == m - 1 && j == n - 1)
                return diff;

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int maxDiff = Math.max(diff, grid[ni][nj]);

                    if (result[ni][nj] > maxDiff) {
                        result[ni][nj] = maxDiff;
                        pq.add(new Pair(ni, nj, maxDiff));
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}