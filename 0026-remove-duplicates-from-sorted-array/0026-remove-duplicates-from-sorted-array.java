class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, p1 = 0,p2 = 0;
        int n = nums.length,cnt = 0;
        while(p1 < n && p2 < n){
            while(p2 < n && nums[p2] == nums[p1]){
                p2++;
            }
            nums[i] = nums[p1];
            p1 = p2;
            i++;
            cnt++;
        }
        return cnt;
    }
}