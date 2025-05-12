class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0,high = n - 1;
        int ans = Integer.MAX_VALUE;
        int bp = -1;
        for(int i = n-2;i >= 0;i--){
            if(nums[i] > nums[i+1]){
                bp = i+1;
                break;
            }
        }
        return Math.min(nums[0],bp == -1 ? Integer.MAX_VALUE : nums[bp]);
    }
}