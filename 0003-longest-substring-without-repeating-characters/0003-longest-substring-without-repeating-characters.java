class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = Integer.MIN_VALUE;
        int count = 0;
        int i = 0;

        if(n == 0) return 0;

        HashSet<Character> set = new HashSet<>();

        for (int j = 0; j < n; j++) {
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}