class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+")|| token.equals("-") || token.equals("*") || token.equals("/")){
                //top 2 element ko nikal kar operator karlo
                //then push the result in the stack

                int b = st.peek();
                st.pop();

                int a = st.peek();
                st.pop();

                int result = operator(a,b,token);

                st.push(result);
            }else
            st.push(Integer.parseInt(token));
        }

        return st.peek();
        
    }

    public int operator(int a,int b,String token){
        if(token.equals("+")){
            return a + b;
        }
        if(token.equals("-")){
            return a - b;
        }
        if(token.equals("*")){
            return (int)((long)a * (long)b);
        }
        if(token.equals("/")){
            return a / b;
        }

        return -1;
    }
}