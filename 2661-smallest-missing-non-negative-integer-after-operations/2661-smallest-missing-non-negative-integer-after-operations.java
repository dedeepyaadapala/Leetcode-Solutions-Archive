class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for(int i: nums){
            cnt[((i % value)+value) % value]++;
        }
        for(int i = 0;i <= nums.length;i++){
            if(cnt[i % value] != 0){
                cnt[i % value]--;
            }else{
                return i;
            }
        }
        return nums.length + 1;
    }
}