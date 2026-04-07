class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        int e = n-1;
        return search(nums,target,s,e);
    }

    public int search(int[] nums,int target,int s,int e){
        if(s>e) return -1;

        int m = s + (e-s)/2;
        if(nums[m]== target){
            return m;
        }

        if(nums[s] <= nums[m]){
            if(target >= nums[s] && target <= nums[m]){
                return search(nums,target,s,m-1);
            }else{
                return search(nums,target,m+1,e);
            }
        }

        if(target >= nums[m] && target <= nums[e]){
            return search(nums,target,m+1,e);
        }else{
            return search(nums,target,s,m-1);
        }
    }
}