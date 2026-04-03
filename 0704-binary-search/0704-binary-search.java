class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int st =0;
        int end = n-1;
        int idx = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(nums[mid] == target){
                idx = mid;
                return idx;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }

        return idx;
    }
}