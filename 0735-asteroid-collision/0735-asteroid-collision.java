class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        

        Stack<Integer> st = new Stack<>();
        for (int a : asteroids) {

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                int sum = a + st.peek();
                if (sum < 0) {
                    st.pop();
                }else if(sum > 0){
                    a= 0;
                    break;
                }else{
                    st.pop();
                    a=0;
                    break;
                }
            }
            if(a!=0) st.push(a);
        }

        int m = st.size();
        int[] a = new int[m];
        for(int i = m-1;i>=0;i--){
            a[i] = st.pop();
        }

        return a;

    }
}