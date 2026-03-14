class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m)
            return false;

        HashMap<Character, Integer> m1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            m2.put(ch, m2.getOrDefault(ch, 0) + 1);
        }

        if(m1.equals(m2)){
            return true;
        }

        return false;
    }
}