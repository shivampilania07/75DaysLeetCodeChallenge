class Solution {
    int n;
    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int prev = -1;
        return solve(nums, 0, -1);
    }

    public int solve(int[] nums, int idx, int prev_idx) {
        if (idx == n)
            return 0;
        if (dp[idx][prev_idx+1] != -1)
            return dp[idx][prev_idx+1];
        int len = solve(nums, idx + 1, prev_idx);
        if (prev_idx == -1 || nums[idx] > nums[prev_idx]) {
            len = Math.max(len, 1 + solve(nums, idx + 1, idx));
        }

        return dp[idx][prev_idx+1] = len;
    }
}