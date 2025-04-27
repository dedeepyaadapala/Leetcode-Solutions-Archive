class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0;i <= n-3;i++){
            if(2*(nums[i] + nums[i+2]) == nums[i+1]) cnt++;
        }
        return cnt;
    }
}