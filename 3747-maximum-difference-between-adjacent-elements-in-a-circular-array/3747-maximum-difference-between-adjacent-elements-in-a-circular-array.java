class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            maxi = Math.max(maxi,Math.abs(nums[i] - nums[(i+1) % n]));
        }
        return maxi;
    }
}