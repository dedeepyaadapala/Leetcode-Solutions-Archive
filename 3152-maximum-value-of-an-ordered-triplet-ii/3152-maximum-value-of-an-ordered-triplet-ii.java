class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long maxVal = 0,maxAbs = 0;
        for(int i = 0;i < n;i++){
            ans = Math.max(ans,maxAbs * nums[i]);
            maxAbs = Math.max(maxAbs,maxVal - nums[i]);
            maxVal = Math.max(maxVal,nums[i]);
        }
        return ans;
    }
}