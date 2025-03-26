class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4){
            return 0;
        }
        Arrays.sort(nums);
        return Math.min(
            Math.min(Math.abs(nums[3]-nums[n-1]),
            Math.abs(nums[2]-nums[n-2])),
            Math.min(Math.abs(nums[1]-nums[n-3]),
            Math.abs(nums[0]-nums[n-4]))
        );
    }
}