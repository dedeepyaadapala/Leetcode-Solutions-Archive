class Solution {
    static int[] dp = new int[5000001];
    static{
        boolean[] isPrime = new boolean[5000001];
        for(int i = 2;i < 5000001;i++){
            isPrime[i] = true;
        }
        for(int i = 2;i * i < 5000001;i++){
            if(isPrime[i]){
                for(int j = i * i;j < 5000001;j += i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2;i < 5000001;i++){
            if(isPrime[i-1]){
                dp[i] = dp[i] + 1;
            }
            dp[i] += dp[i-1];
        }
    }
    public int countPrimes(int n) {
        return dp[n];
    }
}