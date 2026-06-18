class Solution {
    public int divide(int dividend, int divisor) {
        long quot;
        quot=(long)dividend/(long)divisor;
        if(quot>Integer.MAX_VALUE){
        return Integer.MAX_VALUE;
        }
        if(quot<Integer.MIN_VALUE){
        return Integer.MIN_VALUE;
        }

        return (int)quot;

    }
}