class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0l;
        int n = nums.length;
        int left = 0,right = 0;
        while(right < n){
            while(left < n){
                if(nums[left] != 0){
                    left++;
                }else{
                    break;
                }
            }
            right = left;
            while(right < n){
                if(nums[right] == 0){
                    right++;
                }else{
                    break;
                }
            }
            long size = 0l;
            if(left <= right) size = right - left + 1;
            res = res + (size * (size - 1)) / 2;
            left = right + 1;
        }
        return res;
    }
}