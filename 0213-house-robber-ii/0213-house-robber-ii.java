class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int preprev = nums[0];
        int prev = Math.max(nums[0],nums[1]);
        for(int i = 2;i <= n-2;i++){
            int curr = Math.max(preprev+nums[i],prev);
            preprev = prev;
            prev = curr;
        }
        int ans = prev;
        if(n == 2) return ans;
        preprev = nums[1];
        prev = Math.max(preprev,nums[2]);
        for(int i = 3;i < n;i++){
            int curr = Math.max(preprev + nums[i],prev);
            preprev = prev;
            prev = curr;
        }
        return Math.max(ans,prev);
    }
}