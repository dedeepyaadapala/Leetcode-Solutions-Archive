class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        int n = nums.length;
        int prev = 0,curr = 0,ans = 0;
        for(int i = 0;i < n;){
            curr = 0;
            while(i < n && nums[i] == 0){
                i++;
                curr++;
            }
            if(curr > 1){
                prev = 0;
            }
            curr = 0;
            while(i < n && nums[i] == 1){
                curr++;
                i++;
            }
            ans = Math.max(ans,curr+prev);
            prev = curr;
        }
        return ans == n ? n-1 : ans;
    }
}