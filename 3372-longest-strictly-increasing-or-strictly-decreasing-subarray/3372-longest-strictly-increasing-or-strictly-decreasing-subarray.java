class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1,maxi = 1;
        for(int i = 0; i < nums.length - 1;i++){            
            if(nums[i] > nums[i+1]){
                dec += 1;
                if(maxi < dec){
                    maxi = dec;
                }
            }else{
                dec = 1;
            }
            if(nums[i] < nums[i+1]){
                inc += 1;
                if(maxi < inc){
                    maxi = inc;
                }
            }else{
                inc = 1;
            }
        }
        return maxi;
    }
}