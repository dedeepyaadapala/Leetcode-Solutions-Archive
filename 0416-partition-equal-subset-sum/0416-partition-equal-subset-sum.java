class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0;i < n;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        Arrays.sort(nums);
        fillDP(nums,n,target,dp);
        return dp[n-1][target];
    }

    private static void fillDP(int[] nums,int n,int sum,boolean[][] dp){
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= sum;j++){
                dp[i][j] = dp[i-1][j] | (nums[i] <= j && dp[i-1][j-nums[i]]);
            }
        }
    }
}