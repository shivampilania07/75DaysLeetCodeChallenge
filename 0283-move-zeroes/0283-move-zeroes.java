class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int l = n-1;
        for(int i = 0;i<n;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(;j<n;j++){
            nums[j] = 0;
        }
    }
}