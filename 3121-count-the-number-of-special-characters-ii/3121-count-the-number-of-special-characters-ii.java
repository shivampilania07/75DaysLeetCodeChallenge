class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> lowermap = new HashMap<>();
        HashMap<Character,Integer> uppermap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            set.add(ch);
            if(Character.isLowerCase(ch)){
                lowermap.put(ch,i);
            }else{
                if(!uppermap.containsKey(ch)){
                    uppermap.put(ch,i);
                }
            }
        }
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char up = Character.toUpperCase(ch);
            if (set.contains(ch) && set.contains(up) ){
                if(lowermap.get(ch) < uppermap.get(up)){
                    count++;
                }
            }
        }
        return count;
    }
}