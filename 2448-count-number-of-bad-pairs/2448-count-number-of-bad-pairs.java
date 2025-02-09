class Solution {
    public long countBadPairs(int[] nums) {
        long res = 0;
        HashMap<Integer,Long> count = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            count.put(nums[i]-i,count.getOrDefault(nums[i]-i,0l)+1);
        }
        res = ((long)(n) * (long)(n-1)) / 2;
        for(Long pairs : count.values()){
            res = res - (pairs * (pairs-1))/2;
        }
        return res;
    }
}