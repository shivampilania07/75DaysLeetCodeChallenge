class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int m = s.length();
        int count_one = 0;
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                count_one++;
            }
        }

        List<Integer> zeroblock = new ArrayList<>();
        int count_zero = 0;
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                count_zero++;
            } else {
                // Add only a non-empty zero block
                if (count_zero > 0) {
                    zeroblock.add(count_zero);
                    count_zero = 0;
                }
            }
        }

        // Add the last zero block
        if (count_zero > 0) {
            zeroblock.add(count_zero);
        }

        int maxPair = 0;
        for (int i = 0; i < zeroblock.size() - 1; i++) {

            maxPair = Math.max(maxPair, zeroblock.get(i) + zeroblock.get(i + 1));

        }

        return maxPair + count_one;
    }
}