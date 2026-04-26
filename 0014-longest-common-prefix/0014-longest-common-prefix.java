class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();
        String a = strs[0];
        String b = strs[n-1];

        int m = a.length();
        for(int i = 0;i<m;i++){
            char ch = a.charAt(i);
            char ch1 = b.charAt(i);

            if(ch != ch1){
               break;
            }

            if(ch == ch1){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}