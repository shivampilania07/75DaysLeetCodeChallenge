class Solution {
    public int minCut(String s) {
        int n = s.length();

        //Precompute Palindrome Table
        boolean[][] t = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                if (L == 2) {
                    t[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    t[i][j] = (s.charAt(i) == s.charAt(j)) && t[i + 1][j - 1];
                }
            }
        }

        //DP for minimum cuts
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (t[0][i] == true) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int k = 0; k < i; k++) {
                if (t[k + 1][i] == true) {
                    dp[i] = Math.min(dp[i], 1 + dp[k]);
                }
            }
        }

        return dp[n - 1];

    }

}