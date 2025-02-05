class Solution {
    public int divide(int n, int x) {
        long res = 0;
        boolean isNegative = false;
        if(n < 0 && x > 0) isNegative = true;
        if(n > 0 && x < 0) isNegative = true;
        long divisor = Math.abs((long)x);
        long dividend = Math.abs((long)n);
        if(divisor == 1){
            if(isNegative && dividend > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
            if(!isNegative && dividend >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (isNegative ? -(int)dividend : (int)dividend);
        }
        for(int i = 30;i >= 0;i--){
            if(dividend >= divisor * (1l << i)){
                dividend -= divisor * (1l << i);
                res += (1l << i);
            }
            if(res >= Integer.MAX_VALUE){
                return isNegative ?Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNegative ? -(int) res : (int)res;
    }
}