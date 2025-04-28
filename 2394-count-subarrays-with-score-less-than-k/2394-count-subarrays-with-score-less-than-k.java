class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0;
        int left = 0,right = 0;
        long curr = 0l;
        while(left < n){
            while(right < n){
                curr += nums[right];
                if(curr * (right-left+1) >= k){
                    curr -= nums[right];
                    break;
                }
                right++;
            }
            res = res + right-left;
            curr -= nums[left];
            left++;
        }
        return res;
    }
}