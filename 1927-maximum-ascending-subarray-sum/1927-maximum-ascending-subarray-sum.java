class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxi = nums[0];
        int curr = nums[0];
        for(int i = 1;i < n;i++){
            if(nums[i] > nums[i-1]){
                curr += nums[i];
            }else{
                maxi = Math.max(maxi,curr);
                curr = nums[i];
            }
        }
        maxi = Math.max(maxi,curr);
        return maxi;
    }
}