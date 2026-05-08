class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m>n) return false;
        int[] map1 = new int[26];
       

        for(int i = 0;i<m;i++){
            map1[s1.charAt(i)-'a']++;
        }

        for(int i = 0;i<=n-m;i++){
            int[] map2 = new int[26];
            for(int j = 0;j<m;j++){
                map2[s2.charAt(i+j)-'a']++;
                if(isMatched(map1,map2)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatched(int[] map1,int[] map2){
        for(int i = 0;i<26;i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
}