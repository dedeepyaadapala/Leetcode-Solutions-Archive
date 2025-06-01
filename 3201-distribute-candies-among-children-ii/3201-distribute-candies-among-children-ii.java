class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0l;
        for(int i = 0;i <= limit && i <= n;i++){
            if(n - i > 2 * limit) continue;
            res += Math.min(n-i,limit) - Math.max(0,n-i-limit) + 1;
        }
        return res;
    }
}