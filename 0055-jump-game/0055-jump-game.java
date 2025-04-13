class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int i =0;
        while(i < n && dp[i]){
            for(int j = i;j <= i+ nums[i] && j < n;j++){
                dp[j] = true;
            }
            i++;
        }
        return dp[n-1];
    }
}