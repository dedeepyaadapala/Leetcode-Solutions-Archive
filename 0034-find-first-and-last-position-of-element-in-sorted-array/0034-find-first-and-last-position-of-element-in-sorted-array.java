class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstOccurrance(nums,target);
        res[1] = lastOccurrance(nums,target);
        return res;
    }
    private static int firstOccurrance(int[] nums,int target){
        int ans = -1;
        int low = 0,high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid -1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    private static int lastOccurrance(int[] nums,int target){
        int ans = -1;
        int low = 0,high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}