class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1,high = 1;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            high = Math.max(high,nums[i]);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isMidValid(nums,n,mid,threshold)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isMidValid(int[] nums,int n,int mid,int threshold){
        int res = 0;
        for(int i = 0;i < n;i++){
            res += ((nums[i] + mid -1) / mid);
        }
        return res <= threshold;
    }
}