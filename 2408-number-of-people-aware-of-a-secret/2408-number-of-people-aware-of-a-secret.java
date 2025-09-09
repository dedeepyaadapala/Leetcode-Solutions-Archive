class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] curr = new long[n+1];
        curr[1] = 1;
        long sum = 0l;
        for(int i = 1;i <= n;i++){
            for(int j = i+delay;j < i+forget && j <= n;j++){
                curr[j] = (curr[j] + curr[i]) % 1000000007;
            }
        }
        for(int i = Math.max(1,n-forget+1);i <= n;i++){
            sum = (sum + curr[i]) % 1000000007;
        }
        return (int) (sum);
    }
}