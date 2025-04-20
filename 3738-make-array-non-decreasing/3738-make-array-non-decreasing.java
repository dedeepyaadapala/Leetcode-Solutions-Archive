class Solution {
    public int maximumPossibleSize(int[] nums) {
        int n = nums.length;
        int curr = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(curr <= nums[i]){
                curr = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}