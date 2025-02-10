class Solution {
    public int searchInsert(int[] nums, int target) {
        // same as lower bound
        int low = 0, high = nums.length-1;
        int ind  = -1;
        int val = Integer.MIN_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target && val < nums[mid]){
                ind = mid;
                val = nums[mid];
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ind+1;
    }
}