class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            if(nums[i] <= first){
                first = nums[i];
            }else if(nums[i] <= sec){
                sec = nums[i];
            }else if(nums[i] > sec && sec > first){
                return true;
            }
        }
        return false;
    }
}