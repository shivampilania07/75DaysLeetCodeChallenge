class Solution {

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 0; k <= 2; k++) {
                    if (i == m - 1 && j == n - 1) {
                        if (coins[i][j] < 0 && k > 0)
                            dp[i][j][k]= 0;
                        else dp[i][j][k]=coins[i][j];
                        continue;
                    }
                    int right,down;
                    if(j+1<n){
                         right = dp[i][j+1][k];
                    }else{
                        right = Integer.MIN_VALUE;
                    }

                    if(i+1<m){
                         down = dp[i+1][j][k];
                    }else{
                        down = Integer.MIN_VALUE;
                    }

                    int best = Math.max(right,down);
                   int take = (best == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + best;

                    int skip = Integer.MIN_VALUE;
                    if (coins[i][j] < 0 && k > 0) {
                        int skipRight = (j + 1 < n) ? dp[i][j + 1][k - 1] : Integer.MIN_VALUE;
                        int skipDown  = (i + 1 < m) ? dp[i + 1][j][k - 1] : Integer.MIN_VALUE;
                        skip = Math.max(skipRight, skipDown);
                    }
                    dp[i][j][k] = Math.max(take, skip);
                }
            }
        }

        return dp[0][0][2];
    }

    // public int solve(int[][] coins, int i, int j, int skipLeft,int[][][] dp) {
    //     int m = coins.length;
    //     int n = coins[0].length;
    //     int profit = 0;

    //     if (i >= m || j >= n)
    //         return Integer.MIN_VALUE;
    //     if (i == m - 1 && j == n - 1){
    //         if (coins[i][j] < 0 && skipLeft > 0) return 0;
    //         return coins[i][j];
    //     }

    //     if(dp[i][j][skipLeft] != -1) return dp[i][j][skipLeft];

    //     int right, down;
    //     int take;
    //     int skip = Integer.MIN_VALUE;

    //         right = solve(coins, i, j + 1, skipLeft,dp);
    //         down =  solve(coins, i + 1, j, skipLeft,dp);
    //        int best = Math.max(right, down);
    //        take = (best == Integer.MIN_VALUE) ? Integer.MIN_VALUE : coins[i][j] + best;

    //         if (coins[i][j]< 0 && skipLeft > 0) {
    //             right = solve(coins, i, j + 1, skipLeft - 1,dp);
    //             down = solve(coins, i + 1, j, skipLeft - 1,dp);
    //             skip = Math.max(right,down);
    //         }

    //     return dp[i][j][skipLeft] = Math.max(take, skip);

    // }
}