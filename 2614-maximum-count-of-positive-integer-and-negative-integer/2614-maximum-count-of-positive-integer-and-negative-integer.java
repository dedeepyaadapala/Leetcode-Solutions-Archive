class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int low = 0,high = nums.length-1;
        int neg = -1,pos = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < 0){
                neg = mid;
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > 0){
                pos = mid;
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return Math.max(pos == -1 ? 0 : n-pos,neg+1);
    }
}