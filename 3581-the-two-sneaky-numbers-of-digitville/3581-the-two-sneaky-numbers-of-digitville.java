class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length -2;
        int xor = 0;
        for(int i = 0;i < n;i++) xor ^= i;
        for(int i = 0;i < n+2;i++){
            xor = xor ^ nums[i];
        }
        int[] ans = new int[2];
        int pos = 0;
        for(int i = 0;i < 31;i++){
            if((xor & (1 << i)) != 0){
                pos = i;
                break;
            }
        }
        for(int i = 0;i < n+2;i++){
            if((nums[i] & (1 << pos)) == 0){
                ans[0] = ans[0] ^ nums[i];
            }else{
                ans[1] = ans[1] ^ nums[i];
            }
        }
        for(int i = 0;i < n;i++){
            if((i & (1 << pos)) == 0){
                ans[0] = ans[0] ^ i;
            }else{
                ans[1] = ans[1] ^ i;
            }
        }
        return ans;
    }
}