class Solution {
    static int sum = 0;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        generateSubsets(nums,nums.length,0,0);
        return sum;
    }

    private static void generateSubsets(int[] nums,int n,int idx,int curr){
        if(idx == n){
            sum = sum + curr;
            return;
        }
        generateSubsets(nums,n,idx+1,curr ^ nums[idx]);
        generateSubsets(nums,n,idx+1,curr);
    }
}