class Solution {
    public void solve(int[] nums,List<List<Integer>> result,List<Integer> permutation){
        if(permutation.size() == nums.length){
            result.add(new ArrayList(permutation));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            solve(nums,result,permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        solve(nums,result,permutation);
        return result;
    }
}