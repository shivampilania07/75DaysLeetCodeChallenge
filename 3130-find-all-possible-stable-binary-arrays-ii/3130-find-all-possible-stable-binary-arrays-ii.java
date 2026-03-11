class Solution {
    int MOD = (int) 1e9 + 7;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero+1][one+1][2];

        int n = Math.min(zero, limit);
        int m = Math.min(one, limit);

        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i][1] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if(i == 0 || j == 0) continue;

                    dp[i][j][1] = (dp[i][j - 1][1] + dp[i][j - 1][0]) % MOD;

                    if (j - 1 >= limit) {
                        dp[i][j][1] = (dp[i][j][1] - dp[i][j - 1 - limit][0] + MOD) % MOD;
                    }
                

               
                    dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                    if (i - 1 >= limit) {
                        dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                    }
                
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}