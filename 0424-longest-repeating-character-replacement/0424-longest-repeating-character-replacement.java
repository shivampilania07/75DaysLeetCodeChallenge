class Solution {
    public int characterReplacement(String s, int k) {
        int m = s.length();
        int maxfreq = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        HashMap<Character,Integer> map = new HashMap<>();
        int i =0,j=0;
        while(j<m){
            char ch= s.charAt(j);

            map.put(ch,map.getOrDefault(ch,0)+1);

            maxfreq = Math.max(maxfreq,map.get(ch));
          
            if((j-i+1)-maxfreq > k){
                char left = s.charAt(i);
                map.put(left,map.get(left)-1);
                i++;
            }

            max = Math.max(max,j-i+1);
            j++;
        }
        
        return (max == Integer.MIN_VALUE)?-1:max;
    }
}