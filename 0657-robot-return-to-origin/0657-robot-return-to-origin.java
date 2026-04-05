class Solution {
    public boolean judgeCircle(String moves) {
       int x = 0;
       int y = 0;

        int n = moves.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if(ch == 'U') x++;
            else if(ch == 'D') x--;
            else if(ch == 'R') y++;
            else y--;
        }

        return x == 0 && y == 0;
    }
}