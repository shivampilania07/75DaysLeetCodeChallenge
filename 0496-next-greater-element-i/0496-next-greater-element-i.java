class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<m;i++){
            map.put(nums2[i],i);
        }

        for(int i = 0;i<n;i++){
            int num = nums1[i];
            int idx = map.get(num);
            for(int j = idx;j<m;j++){
                if(nums2[j] > num){
                    ans[i] = nums2[j];
                    break;
                }

                if(j==m-1) ans[i] = -1;
            }
        }
        return ans;
    }
}