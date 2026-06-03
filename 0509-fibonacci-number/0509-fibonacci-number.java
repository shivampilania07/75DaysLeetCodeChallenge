class Solution {
    // public int solve(int n, int[] dp) {
    //     if (n <= 1)
    //         return n;
    //     if (dp[n] != -1) {
    //         return dp[n];
    //     }
    //     return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    // }

    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        int a = 0;
        int b = 1;

        for (int i = 2; i <=n; i++) {
            int c = (b+a);   //next value
                a=b;        // now second become first
                b=c;        // third become second
        }
        return b;
    }
}