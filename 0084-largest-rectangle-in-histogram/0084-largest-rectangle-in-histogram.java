class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ns = findNextSmaller(heights);
        int[] ps = findPrevSmaller(heights);

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<heights.length;i++){
            int h = heights[i];
            int w = ns[i]-ps[i]-1;
            max = Math.max(max,(h*w));
        }
        return max;
    }

    public int[] findNextSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = n;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] findPrevSmaller(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;

    }
}