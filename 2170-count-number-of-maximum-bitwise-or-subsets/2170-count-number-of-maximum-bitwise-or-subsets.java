class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int or = 0;
        for(int i : nums){
            or = or | i;
        }
        return findMaxOr(nums,n,0,or,0);
    }

    private static int findMaxOr(int[] nums,int n,int idx,int val,int curr){
        if(idx == n) return curr == val ? 1 : 0;
        int take = findMaxOr(nums,n,idx+1,val,curr|nums[idx]);
        int notTake = findMaxOr(nums,n,idx+1,val,curr);
        return take + notTake;
    }
}