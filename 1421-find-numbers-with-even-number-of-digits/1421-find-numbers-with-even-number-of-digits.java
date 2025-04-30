class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int num = nums[i];
            int dig = 0;
            while(num > 0){
                dig++;
                num /= 10;
            }
            cnt += (dig % 2 == 0 ? 1 : 0);
        }
        return cnt;
    }
}