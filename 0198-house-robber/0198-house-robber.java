class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int preprev = nums[0];
        int prev = Math.max(preprev,nums[1]);
        for(int i = 2;i < n;i++){
            int curr = Math.max(prev,preprev+nums[i]);
            preprev = prev;
            prev = curr;
        }
        return prev;
    }
}