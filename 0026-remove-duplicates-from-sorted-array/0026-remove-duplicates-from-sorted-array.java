class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
        }

        int i = 0;
        for(int num : set){
            nums[i++]=num;
        }
        return set.size();
    }
}