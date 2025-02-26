class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int positive = 0,negative = 0,posSum = 0,negSum = 0;
        int maxi = 0, n = nums.length;
        boolean isNegative = false;
        for(int i = 0;i < n;i++){
            posSum += nums[i];
            negSum += nums[i];
            if(posSum >= 0){
                positive = Math.max(positive,posSum);
            }else{
                posSum = 0;
            }
            if(negSum <= 0){
                negative = Math.min(negative,negSum);
            }else{
                negSum = 0;
            }
        }
        maxi = Math.max(positive,-negative);
        return maxi;
    }
}