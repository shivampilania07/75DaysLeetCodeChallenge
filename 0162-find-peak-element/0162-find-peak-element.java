class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }

        if(n == 1) return 0;
        if(n==2) return (nums[0]>nums[1])?0:1;
        for(int i = 0;i<n;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    return i;
                }
            }

            if(i==n-1){
                if(nums[i]>nums[i-1]){
                    return i;
                }
            }
        }

        return -1;
    }
}