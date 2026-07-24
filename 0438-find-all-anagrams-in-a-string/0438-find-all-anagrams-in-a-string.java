class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> ans = new ArrayList<>();
        if(m<n){
            return ans;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of characters in p
        for (int i = 0; i < n; i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pFreq, windowFreq)) {
            ans.add(0);
        }

         // Slide the window
        for (int i = n; i < m; i++) {

            // Add new character
            windowFreq[s.charAt(i) - 'a']++;

            // Remove old character
            windowFreq[s.charAt(i - n) - 'a']--;

            int start = i - n + 1;

            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(start);
            }
        }

        return ans;
       

    }
}