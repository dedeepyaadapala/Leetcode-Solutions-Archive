class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int nonZeroProduct = 1;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(nums[i] == 0) cnt++;
            else nonZeroProduct *= nums[i];
        }
        for(int i = 0;i < n;i++){
            if(cnt > 0 && nums[i] == 0){
                if(cnt > 1) ans[i] = 0;
                else ans[i] = nonZeroProduct;
            }else if (cnt > 0 && nums[i] != 0){
                ans[i] = 0;
            }else{
                ans[i] = nonZeroProduct / nums[i];
            }
        }
        return ans;
    }
}