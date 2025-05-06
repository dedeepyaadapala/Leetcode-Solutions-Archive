class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxi = 0;
        for(int i = 0;i < k;i++){
            maxi += nums[i];
        }
        double curr = maxi;
        for(int i = k;i < nums.length;i++){
            curr += nums[i] - nums[i-k];
            if(curr > maxi){
                maxi = curr;
            }
        }
        return maxi/k;
    }
}