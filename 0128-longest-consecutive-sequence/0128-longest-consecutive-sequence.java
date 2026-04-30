class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n==0) return 0;

        int count = 1;
        int max = 1;
        for (int i = 0; i < n-1; i++) {
            int one = nums[i];
            if(one == nums[i+1]){
                continue;
            }
            else if(one+1 == nums[i+1]){
                count++;
            }
            else{
                count=1;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}