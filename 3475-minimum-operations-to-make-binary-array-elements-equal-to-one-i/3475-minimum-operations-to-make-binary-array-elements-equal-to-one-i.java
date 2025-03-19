class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i <= n-3;i++){
            if(nums[i] == 0){
                cnt++;
                nums[i] = 1 ^ nums[i];
                nums[i+1] = 1 ^ nums[i+1];
                nums[i+2] = 1 ^ nums[i+2];
            }
        }
        return nums[n-2] == 0 || nums[n-1] == 0 ? -1 : cnt;
    }
}