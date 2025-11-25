class Solution {
    public int smallestRepunitDivByK(int k) {
        int n = 1;
        for(int i = 1;i <= k;i++){
            int rem = n % k;
            if(rem == 0) return i;
            n = (rem * 10) + 1;
        }
        return -1;
    }
}