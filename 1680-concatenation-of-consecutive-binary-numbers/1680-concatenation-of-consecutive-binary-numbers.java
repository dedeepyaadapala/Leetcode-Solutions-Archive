class Solution {
    static long mod = 1000000007;
    public int concatenatedBinary(int n) {
        long ans = 0;
        long p = 1;
        for(int i = n;i >= 1;i--){
            int temp = i;
            while(temp > 0){
                ans = (ans +(p * (temp % 2)) % mod) % mod;
                temp = temp / 2;
                p = (p * 2) % mod;
            }
        }
        return (int) ans;
    }
}