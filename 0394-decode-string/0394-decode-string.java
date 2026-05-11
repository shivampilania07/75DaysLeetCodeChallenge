class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> ss = new Stack<>();
        Stack<Integer> sn = new Stack<>();
        String curr = "";
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                sn.push(num);
                ss.push(curr);
                num = 0;
                curr = "";
            } else if (ch == ']') {
                int k = sn.pop();
                String prev = ss.pop();
                StringBuilder sb = new StringBuilder(prev);
                for (int i = 0; i < k; i++) {
                    sb.append(curr);
                }
                curr = sb.toString();
            } else {
                curr += ch;
            }
        }
        return curr;
    }
}