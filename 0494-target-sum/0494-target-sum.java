class Solution {
    public int solve(int[] nums,int target,int i){
        int n = nums.length;
        if(i == n){
        if(target == 0)
        {
            return 1;
        }
        return 0;
        }

        int takeplus = solve(nums,target+nums[i],i+1);
        int takeminus = solve(nums,target-nums[i],i+1);

        return (takeplus + takeminus);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0);
    }
}