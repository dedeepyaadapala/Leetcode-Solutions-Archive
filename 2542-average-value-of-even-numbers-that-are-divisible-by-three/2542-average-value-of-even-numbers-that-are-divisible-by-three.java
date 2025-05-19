class Solution {
    public int averageValue(int[] nums) {
        int n = nums.length;
        int sum = 0,cnt = 0;
        for(int i = 0;i < n;i++){
            if(nums[i] % 6 == 0){
                sum += nums[i];
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}