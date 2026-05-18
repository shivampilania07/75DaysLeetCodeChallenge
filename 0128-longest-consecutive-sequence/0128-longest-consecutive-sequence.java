class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n==1) return 1;
        if(n==0) return 0;

        int count = 1;
        int maxCount = 1;
        for(int i = 0;i<n-1;i++){
            if(nums[i]+1 == nums[i+1]){
                count++;
                maxCount = Math.max(count,maxCount);
            }else if(nums[i] == nums[i+1]){
                continue;
            }else if(nums[i]+1 != nums[i+1]){
                count = 1;
            }
        }
        return maxCount;
    }
}