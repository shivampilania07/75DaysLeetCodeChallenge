class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n-1;i+=1){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            i++;
        }
        return nums[n-1];
    }
}