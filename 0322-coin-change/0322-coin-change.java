class Solution {
    static int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        // Arrays.sort(coins);
        ans = Integer.MAX_VALUE;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],-1);
            dp[i][0] = 0;
        }
        for(int i = 1;i <= amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }
        }
        checkPossibilities(coins,n-1,amount,dp);
        return dp[n-1][amount] == 1000000007 ? -1 : dp[n-1][amount];
    }

    private static int checkPossibilities(int[] coins,int idx,int amount,int[][] dp){
        if(idx == 0){
            if(amount % coins[0] == 0) return (amount / coins[0]);
            return 1000000007;
        }
        if(amount < 0) return 1000000007;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take = 1000000007;
        if(coins[idx] <= amount) take = 1 + checkPossibilities(coins,idx,amount - coins[idx],dp);
        int notTake = checkPossibilities(coins,idx-1,amount,dp);
        return dp[idx][amount] = Math.min(take,notTake);
    }
}