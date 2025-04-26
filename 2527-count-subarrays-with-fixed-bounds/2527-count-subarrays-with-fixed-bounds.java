class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIdx = -1,maxIdx = -1, invalid = -1;
        long cnt = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] < minK || nums[i] > maxK) invalid = i;
            if(nums[i] == minK) minIdx = i;
            if(nums[i] == maxK) maxIdx = i;
            cnt += Math.max(
                0,
                Math.min(minIdx,maxIdx) - invalid
            );
        }
        return cnt;
    }
}