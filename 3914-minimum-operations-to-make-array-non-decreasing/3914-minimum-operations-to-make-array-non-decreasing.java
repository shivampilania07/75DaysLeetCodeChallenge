class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                sum+=(nums[i]-nums[i+1]);
            }
        }
        return sum;
    }
}