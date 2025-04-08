class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = n-1;i >= 0;i--){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                break;
            }
        }
        int cnt = n - set.size();
        return (cnt) / 3 + (cnt % 3 > 0 ? 1 : 0);
    }
}