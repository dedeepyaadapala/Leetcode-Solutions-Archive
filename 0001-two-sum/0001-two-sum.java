class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<Integer> cnt = new HashSet<>();
        int[] res = new int[2];
        int i = 0;
        for(;i < n;i++){
            if(cnt.contains(target-nums[i])){
                res[1] = i;
                break;
            }
            cnt.add(nums[i]);
        }
        for(int j = 0;j < i;j++){
            if(nums[j] == target - nums[i]){
                res[0] = j;
                break;
            }
        }
        return res;
    }
}