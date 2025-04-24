class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            set.add(nums[i]);
        }
        int cnt = 0;
        for(int i = 0;i < n;i++){
            HashSet<Integer> check = new HashSet<>();
            for(int j = i;j < n;j++){
                check.add(nums[j]);
                cnt += (check.size() == set.size() ? 1 : 0);
            }
        }
        return cnt;
    }
}