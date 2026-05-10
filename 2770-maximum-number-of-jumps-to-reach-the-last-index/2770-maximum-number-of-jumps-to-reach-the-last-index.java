class Solution {
    int n;
    int[] dp;
    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result = solve(0, nums, target);
        return result < 0 ? -1 : result;
    }

    public int solve(int i, int[] nums, int target) {
        if (i == n - 1) {
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int result = Integer.MIN_VALUE;
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                int temp = 1 + solve(j,nums,target);
                result = Math.max(result,temp);
            }
        }
        return dp[i] = result; 
    }
}